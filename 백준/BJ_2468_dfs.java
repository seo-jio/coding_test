import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2468_dfs {
    static int N;
    static int[][] grid;
    static boolean[][] visited;
    static int height;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int DIR_NUM = 4;
    static int max = 0;

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
                        visited[i][j] = true;
                        cnt++;
                        dfs(i, j);
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


    static void dfs(int x, int y){
        for(int i=0; i<DIR_NUM; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(canGo(nx, ny)){
                visited[nx][ny] = true;
                dfs(nx, ny);
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
