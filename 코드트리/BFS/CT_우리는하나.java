package 코드트리.BFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class CT_우리는하나 {
    static int N;
    static int K;
    static int U;
    static int D;
    static int[][] grid;
    static boolean[][] visited;
    static Queue<Pair> queue;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] nums;

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        grid = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                queue.add(new Pair(i, j));
                visited[i][j] = true;
                bfs();
            }
        }
    }

    private static boolean inRange(int x, int y){
        return x >= 0 && x < N && y >= 0 && y <N;
    }

    private static boolean canGo(int nx, int ny, int x, int y){
        int sub = Math.abs(grid[nx][ny] - grid[x][y]);
        if(inRange(nx, ny) && !visited[nx][ny] && sub >= U && sub <= D){
            return true;
        }
        return false;
    }

    private static void bfs(){
        while (!queue.isEmpty()){
            Pair cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(canGo(nx, ny, x, y)){
                    visited[nx][ny] = true;
                    queue.offer(new Pair(nx, ny));
                }
            }
        }
    }

    private static void Combi(int cnt, int start){
        if(cnt == K){

            return;
        }
//        for(int i=start; i<N; i++){
//            for(int j=)
//        }
    }
}
