package 코드트리.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CT_계단오르기 {
    static int N;
    static int[] memo;
    static int MOD = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        memo = new int[N + 1];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        memo[1] = 0;
        System.out.println(stair(N));
    }

    private static int stair(int n) {
        if (memo[n] != -1) {
            return memo[n];
        }
        if (n == 2 || n == 3) {
            return memo[n] = 1 % MOD;
        }
        return memo[n] = (stair(n - 2) + stair(n - 3)) % MOD;
    }
}
