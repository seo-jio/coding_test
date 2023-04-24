import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2629 {
    static int N, M; // N : 추의 개수, M : 구슬개수
    static int[] weights, marbles, dp;
    static int OFFSET = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        weights = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        marbles = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            marbles[i] = Integer.parseInt(st.nextToken());
        }
        // dp 배열 초기화
        int off = N * OFFSET;
        dp = new int[2 * off + 1];
        dp[weights[0] + off] = 1;
        dp[weights[0] * -1 + off] = 1;

        for (int i = 1; i < N; i++) { // 수열 순회
            int[] subtractDp = Arrays.copyOf(dp, dp.length);
            for (int j = 2 * off; j >= 0; j--) { // 더해 줄 때는 오른쪽부터 순회
                if (dp[j] == 0) {
                    continue;
                }
                dp[j + weights[i]] = 1;
            }
            for (int j = 0; j <= 2 * off; j++) { // 빼 줄 때는 왼쪽 부터 순회
                if (dp[j] == 0) {
                    continue;
                }
                dp[j - weights[i]] = 1;
            }
            dp[weights[i] + off] = 1;
            synch(dp, subtractDp);
        }

        System.out.println(Arrays.toString(dp));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            if (dp[marbles[i]] == 1) {
                sb.append("Y").append(" ");
            } else {
                sb.append("N").append(" ");
            }
        }
        System.out.println(sb);
    }

    private static void synch(int[] dp, int[] subtractDp) { // 더했을 경우만 고려한 배열에 뺏을 경우를 고려한 배열을 동기화
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == 0 && subtractDp[i] != 0) { // 더한 경우에는 나타나지 않지만 뺀 경우에 가능한 값이 있는 경우
                dp[i] = 1;
            }
        }
    }

}