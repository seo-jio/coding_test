import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_최장증가부분수열 {
    static int T;
    static int N;
    static int[] nums;
    static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            nums = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            memo = new int[N];
            Arrays.fill(memo, 1);

            for (int i = 1; i < N; i++) {
                for (int j = 0; j < i; j++) {
                    if(nums[j] >= nums[i]) continue;
                    memo[i] = Math.max(memo[i], memo[j]+1);
                }
            }

            int ans = 0;
            for (int i = 0; i < N; i++) {
                ans = Math.max(ans, memo[i]);
            }
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
