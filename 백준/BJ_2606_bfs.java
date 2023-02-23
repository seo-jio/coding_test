import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2606_bfs {
    static int N;
    static int R;
    static int[][] grid;
    static int cnt;
    static Queue<Integer> q = new LinkedList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        R = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        grid = new int[N+1][N+1];
        for(int i=0; i<R; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            grid[s][d] = 1;
            grid[d][s] = 1;
        }
        q.add(1);
        visited[1] = true;
        bfs();
        System.out.println(cnt);
    }

    public static void bfs(){
        while (!q.isEmpty()){
            int cur = q.poll();
            for(int i=0; i<=N; i++){
                if(grid[cur][i] == 1 && !visited[i]){
                    q.offer(i);
                    cnt++;
                    visited[i] = true;
                }
            }
        }
    }
}
