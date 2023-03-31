import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_숫자만들기 {
    static int T;
    static int N;
    static int[] operators; // +, -, *, / 순서임에 유의
    static int[] orders; // 순열을 구해 저장할 배열
    static int[] numbers;
    static int max;
    static int min;
    static StringBuilder sb = new StringBuilder();;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());

            // operators 입력
            operators = new int[4];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                operators[i] = Integer.parseInt(st.nextToken());
            }

            // 순열 때 사용할 배열을 연산자의 수만큼 크기를 갖도록 초기화
            orders = new int[N - 1];

            // 숫자들 입력 받기
            numbers = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            max = -Integer.MAX_VALUE;
            min = Integer.MAX_VALUE;
            perm(0, numbers[0]);
            sb.append("#").append(tc).append(" ").append(max - min).append("\n");
        }
        System.out.print(sb.toString());
    }

    static void perm(int cnt, int ans) { // 연산자는 cnt가 N-1까지 돌면 어짜피 다 써진다는 걸 생각하자
        if (cnt == N - 1) {
            // System.out.println(Arrays.toString(orders));
            max = Math.max(max, ans);
            min = Math.min(min, ans);
            return;
        }
        for (int i = 0; i < 4; i++) { // index로 "+, -, *, /"를 구분
            if (operators[i] == 0)
                continue;
            operators[i]--;
            orders[cnt] = i;
            switch (i) {
                case 0:
                    perm(cnt + 1, ans + numbers[cnt + 1]);
                    break;
                case 1:
                    perm(cnt + 1, ans - numbers[cnt + 1]);
                    break;
                case 2:
                    perm(cnt + 1, ans * numbers[cnt + 1]);
                    break;
                case 3:
                    perm(cnt + 1, ans / numbers[cnt + 1]);
                    break;
            }
            operators[i]++;
        }
    }
}