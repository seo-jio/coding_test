import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[50001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int[] bags = { 3, 5 };
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < bags.length; j++) {
                int beforeSum = i - bags[j];
                if (beforeSum < 0) {
                    continue;
                }
                if (dp[beforeSum] == Integer.MAX_VALUE) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[beforeSum] + 1);
            }
        }
        if (dp[N] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[N]);
        }
    }
}