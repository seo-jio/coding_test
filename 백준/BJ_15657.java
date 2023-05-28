import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15657 {
    static int N, M;
    static int[] nums, choosed;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        choosed = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        combi(0, 0);
        System.out.println(sb);
    }

    private static void combi(int cnt, int start) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                sb.append(choosed[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < N; i++) {
            choosed[cnt] = nums[i];
            combi(cnt + 1, i);
            choosed[cnt] = 0;
        }
    }
}
