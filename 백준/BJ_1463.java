import java.util.*;
import java.io.*;

public class BJ_1463 {
    static int N;
    static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        memo = new int[1000000 + 1];
        memo[1] = 0;
        memo[2] = 1;
        memo[3] = 1;
        for (int i = 4; i <= N; i++) {
            memo[i] = memo[i - 1];
            if (i % 2 == 0) {
                memo[i] = Math.min(memo[i], memo[i / 2]);
            }
            if (i % 3 == 0) {
                memo[i] = Math.min(memo[i], memo[i / 3]);
            }
            memo[i] += 1;
        }
        System.out.println(memo[N]);
    }
}
