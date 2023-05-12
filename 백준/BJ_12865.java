import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_12865 {
    static int N, K;
    static int[] weights, values;
    static int[][] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        weights = new int[N+1];
        values = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        memo = new int[N+1][K+1];

        for (int item = 1; item < N + 1; item++) { //물건
            int itemWeight = weights[item];
            int itemValue = values[item];
            for (int weight = 1; weight < K + 1; weight++) { //무게
                if(itemWeight > weight){
                    memo[item][weight] = memo[item-1][weight];
                }else{
                    memo[item][weight] = Math.max(memo[item-1][weight], itemValue + memo[item-1][weight - itemWeight]);
                }
            }
        }

        System.out.println(memo[N][K]);
    }
}
