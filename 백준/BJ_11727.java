import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_11727 {
    static int N;
    static int[] memo;
    static int MOD = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        memo = new int[1000 + 1];

        memo[0] = 1;
        memo[1] = 1;

        for (int i = 2; i <= N; i++) {
            memo[i] = (memo[i - 1] % MOD + (2 * memo[i - 2]) % MOD) % MOD;
        }
        System.out.println(memo[N]);
    }
}
