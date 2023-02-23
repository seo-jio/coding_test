import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2606_dfs {
    static int N;
    static int E;
    static int[][] grid;
    static int cnt;
    static Queue<Integer> q = new LinkedList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        grid = new int[N+1][N+1];
        for(int i = 0; i< E; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            grid[s][d] = 1;
            grid[d][s] = 1;
        }

        visited[1]= true;
        dfs(1);
        int cnt = 0;
//        System.out.println(Arrays.toString(visited));
        for(int i=1; i<=N; i++){
            if(i!=1 && visited[i]){
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static void dfs(int cur){
        for(int i=1; i<=N; i++){
            if(grid[cur][i] == 1 && !visited[i]){
                visited[i] = true;
                dfs(i);
            }
        }
    }
}
