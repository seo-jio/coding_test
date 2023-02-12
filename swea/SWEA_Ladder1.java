import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_Ladder1 {
    static int[][] grid;
    static final int DIR_NUM = 3;
    static boolean[][] visited;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int tc=1; tc<=10; tc++){
            int t = Integer.parseInt(br.readLine());
            visited = new boolean[100][100];
            grid = new int[100][100];
            for(int i=0; i<100; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<100; j++){
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int dr = -1;
            int dc = -1;
            //도착지점에 row, column을 찾음
            for(int i=0; i<100; i++){
                for(int j=0; j<100; j++){
                    if(grid[i][j] == 2){
                        dr = i;
                        dc = j;
                    }
                }
            }

            dfs(dr, dc);
            System.out.printf("#%d, %d\n", tc, ans);
        }
    }

    public static boolean inRange(int x, int y){
        return x >= 0 && x < 100 && y >= 0 && y < 100;
    }

    public static boolean canGo(int x, int y){
        if(inRange(x, y) && grid[x][y] == 1 && !visited[x][y]){
            return true;
        }
        return false;
    }

    public static void dfs(int x, int y){
        if(x == 0){
            ans = y;
            return;
        }

        int[] dx = new int[]{0, 0, -1};
        int[] dy = new int[]{1, -1, 0};

        for(int dir = 0; dir < DIR_NUM; dir++){
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(canGo(nx, ny)){
                visited[nx][ny] = true;
                dfs(nx, ny);
                break; //도착하면 더이상 for문이 ㅗㄷㄹ지 않게 하기 위해 break를 걸어준다.
            }
        }
    }
}