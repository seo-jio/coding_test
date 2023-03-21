import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_등산로조성 {
    static int T, N, K;
    static int[][] grid;
    static boolean[][] visited;
    static StringTokenizer st;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int maxLength;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            grid = new int[N][N];
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //최고 높이 찾기
            int high = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    high = Math.max(high, grid[i][j]);
                }
            }

            maxLength = Integer.MIN_VALUE;
            //봉우리 찾기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(grid[i][j] == high){
                        visited = new boolean[N][N];
                        visited[i][j] = true;
                        dfs(i, j, 1, false); //길이는 1부터 시작, cut은 false부터 시작
                        visited[i][j] = false;
//                        System.out.println("maxLength : " + maxLength);
                    }
                }
            }

            System.out.println("#" + tc + " " + maxLength);

        }
    }

    private static void dfs(int x, int y, int cnt, boolean isCut){
        maxLength = Math.max(maxLength, cnt);
        for(int d=0; d<4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(canGo(nx, ny, x, y)){
                visited[nx][ny] = true;
                dfs(nx, ny, cnt+1, isCut);
                visited[nx][ny] = false;
            }else{
                if(!isCut && inRange(nx, ny)){ //한 번도 깎은 적이 없고 범위 안에 들어온다면
                    for(int i=1; i<=K; i++){
                        grid[nx][ny] -= i;
                        if(canGo(nx, ny, x, y)){
                            visited[nx][ny] = true;
                            dfs(nx, ny, cnt+1, true);
                            visited[nx][ny] = false;
                        }
                        grid[nx][ny] += i;
                    }
                }
            }
        }
    }

    private static boolean inRange(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    //x, y : 가려고 선택한 위치, px, py 현재 위치
    private static boolean canGo(int x, int y, int px, int py){
        if(inRange(x, y) && !visited[x][y] && grid[x][y] < grid[px][py]){
            return true;
        }
        return false;
    }
}
