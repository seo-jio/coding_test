import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CT_부분수열의합 {
    static int N, M;
    static int[] nums;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[M + 1];
        for (int i = 0; i < M + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            for (int j = M; j >= 0; j--) {
                if(j - nums[i] >= 0){
                    if(dp[j - nums[i]] == Integer.MAX_VALUE){ //선택할 수 없는 경우
                        continue;
                    }
                    dp[j] = Math.min(dp[j], dp[j - nums[i]] + 1);
                }
            }
        }

        if(dp[M] == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(dp[M]);
        }
                
    }
}
