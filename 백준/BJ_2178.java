import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class BJ_2178 {
    static int N, M;
    static int[][] grid;
    static int[][] visited;
    static int min;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Pair> pairs;

    static class Pair {
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N][M];
        visited = new int[N][M];
        for(int i=0; i<N; i++){
            char[] str = br.readLine().toCharArray();;
            for(int j=0; j<M; j++){
                grid[i][j] = str[j]-'0';
            }
        }
        pairs = new LinkedList<>();
        pairs.offer(new Pair(0, 0));
        visited[0][0] = 1;
        bfs();
    }

    public static void bfs(){
        while(!pairs.isEmpty()){
            Pair cur = pairs.poll();
            int x = cur.x;
            int y = cur.y;
            if(x==N-1 && y==M-1){
                System.out.println(visited[N-1][M-1]);
                return;
            }
            for(int d=0; d<4; d++){
                int nx = x + dx[d];
                int ny= y + dy[d];
                if(canGo(nx, ny)){
                    visited[nx][ny] = visited[x][y]+1;
                    pairs.add(new Pair(nx, ny));
                }
            }
        }
    }

    static boolean inRange(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    static boolean canGo(int x, int y){
        if(inRange(x, y) && grid[x][y] == 1 && visited[x][y] == 0){
            return true;
        }
        return false;
    }
}
