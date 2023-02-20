import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//bfs
public class SWEA_1861 {
    static int T;
    static int N;
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
    static StringTokenizer st;
    static int max;
    static int cnt;
    static int x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            N = Integer.parseInt(br.readLine());
            grid = new int[N][N];
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            max = -Integer.MAX_VALUE;
            x = Integer.MAX_VALUE;
            y = Integer.MAX_VALUE;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    cnt = 1;
                    visited = new boolean[N][N];
                    visited[i][j] = true;
                    queue = new LinkedList<>();
                    queue.offer(new Pair(i, j));
                    bfs();
                    if(max < cnt){
                        x = i;
                        y = j;
                        max = cnt;
                    }else if(max == cnt){
                        if(grid[x][y] > grid[i][j]){
                            x = i;
                            y = j;
                        }
                    }
                }
            }
            System.out.printf("#%d %d %d\n", tc, grid[x][y], max);
        }
    }

    private static boolean inRange(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    private static boolean canGo(int nx, int ny, int x, int y){
        if(inRange(nx, ny) && !visited[nx][ny]){
            int diff = grid[nx][ny] - grid[x][y];
            if(diff == 1){
                return true;
            }
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
                    cnt++;
                    break;
                }
            }
        }
    }
}

