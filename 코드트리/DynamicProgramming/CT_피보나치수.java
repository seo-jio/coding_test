import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CT_피보나치수 {
    static int N;
    static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        memo = new int[N+1];
        for (int i = 0; i < N+1; i++) { //-1로 초기화
            memo[i] = -1;
        }
        System.out.println(fibonacciWithTabulation(N));
    }

    private static int fibonacciWithMemoization(int n){
        if(memo[n] != -1){
            return memo[n];
        }
        if(n <= 2){
            return memo[n] = 1;
        }
        return memo[n] = fibonacciWithMemoization(n-1) + fibonacciWithMemoization(n-2);
    }

    private static int fibonacciWithTabulation(int n){
        memo[1] = 1;
        memo[2] = 1;
        for (int i = 3; i <= n; i++) {
            memo[i] = memo[i-1] + memo[i-2];
        }
        System.out.println(Arrays.toString(memo));
        return memo[n];
    }
}
