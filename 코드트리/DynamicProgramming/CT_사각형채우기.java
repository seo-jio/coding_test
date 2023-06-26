package 코드트리.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CT_사각형채우기 {
    static int N;
    static int[] memo;
    static int MOD = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        memo = new int[N+1];
        Arrays.fill(memo, -1);
        memo[0] = 1;
        memo[1] = 1;

        System.out.println(fillBlock(N));
    }

    private static int fillBlock(int n){
        if(memo[n] != -1){
            return memo[n];
        }
        return memo[n] = (fillBlock(n-1) + fillBlock(n-2)) % MOD;
    }
}
