import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_숫자만들기_중복순열 {
    static int T;
    static int N;
    static int[] operators;
    static int[] numbers;
    static int max;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());

            operators = new int[4];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                operators[i] = Integer.parseInt(st.nextToken());
            }

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
        System.out.print(sb);
    }

    private static void perm(int cnt, int res) { // res는 연산결과
        if (cnt == N - 1) {
            max = Math.max(max, res);
            min = Math.min(min, res);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (operators[i] == 0)
                continue;
            operators[i]--;
            switch (i) {
                case 0:
                    perm(cnt + 1, res + numbers[cnt + 1]);
                    break;
                case 1:
                    perm(cnt + 1, res - numbers[cnt + 1]);
                    break;
                case 2:
                    perm(cnt + 1, res * numbers[cnt + 1]);
                    break;
                case 3:
                    perm(cnt + 1, res / numbers[cnt + 1]);
                    break;
            }
            operators[i]++;
        }
    }
}
