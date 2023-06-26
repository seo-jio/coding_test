package 코드트리.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CT_사각형채우기3 {
    static int N;
    static int MOD = 1000000007;
    static long[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        memo = new long[N+1];
        Arrays.fill(memo, -1);
        System.out.println(fillBlock(N));
    }

    private static long fillBlock(int n) {
        memo[0] = 1;
        memo[1] = 2;
        if(n >= 2){
            memo[2] = 7;
        }
        for (int i = 3; i <= n; i++) {
            memo[i] = (2*memo[i-1] + 4*memo[i-2]) % MOD;
        }
        return memo[n];
    }
}

