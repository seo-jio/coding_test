import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_장훈이의높은선반 {
    static int T, N, B;
    static int[] clerks;
    static boolean[] visited;
    static int minSub;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = null;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            clerks = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                clerks[i] = Integer.parseInt(st.nextToken());
            }
            visited = new boolean[N];
            minSub = Integer.MAX_VALUE;
            subSet(0, 0);
            sb.append("#").append(tc).append(" ").append(minSub).append("\n");
        }
        System.out.println(sb);
    }

    private static void subSet(int cnt, int sum){
        if (cnt == N) {
            if(sum >= B){
                minSub = Math.min(minSub, sum - B);
            }
            return;
        }
        visited[cnt] = true;
        subSet(cnt+1, sum+clerks[cnt]);
        visited[cnt] = false;
        subSet(cnt + 1, sum);
    }
}
