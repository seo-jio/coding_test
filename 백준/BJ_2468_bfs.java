import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2468_bfs {
    static int N;
    static int[][] grid;
    static boolean[][] visited;
    static int height;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int DIR_NUM = 4;
    static int max = 0;
    static Queue<Pair> pairs;
    static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int h=0; h<=101; h++){ // 비의 높이
            height = h;
            visited = new boolean[N][N];
            int cnt = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(canGo(i, j)){
                        pairs = new LinkedList<>();
                        visited[i][j] = true;
                        pairs.add(new Pair(i, j));
                        cnt++;
                        bfs();
                    }
                }
            }
            if(cnt == 0){
                break;
            }
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }

    public static void bfs(){
        while(!pairs.isEmpty()){
            Pair cur = pairs.poll();
            int x = cur.x;
            int y = cur.y;
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(canGo(nx, ny)){
                    visited[nx][ny] = true;
                    pairs.offer(new Pair(nx, ny));
                }
            }
        }
    }


    static boolean inRange(int x, int y){
        return x >= 0 && x < N && y >= 0 && y <N;
    }

    static boolean canGo(int x, int y){
        if(inRange(x, y) && grid[x][y] > height && !visited[x][y]){
            return true;
        }
        return false;
    }
}
