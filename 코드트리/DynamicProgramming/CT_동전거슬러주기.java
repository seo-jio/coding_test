package 코드트리.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CT_동전거슬러주기 {
    static int N, M;
    static int[] coins;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        coins = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[M + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // dp[i] : 동전의 합이 i일 때 가능한 최대 동전의 개수
        for (int i = 1; i < M + 1; i++) {
            for (int j = 0; j < N; j++) {
                int beforeSum = i - coins[j];
                if (beforeSum < 0) { // 현재 선택한 동전의 금액이 맞춰야하는 동전의 합보다 작은 경우
                    continue;
                }
                if (dp[beforeSum] == Integer.MAX_VALUE) { // 해당금액을 만드는 것이 불가능한 경우
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[beforeSum] + 1);
            }
        }

        if (dp[M] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[M]);
        }
    }
}
