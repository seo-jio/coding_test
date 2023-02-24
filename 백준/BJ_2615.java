import java.io.*;
import java.util.*;
public class BJ_2615 {
    static int[][] grid = new int[21][21];
    static int[] dxs = {-1, 0, 1, 1};
    static int[] dys = {1, 1, 1, 0};
    static int DIR_NUM = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=1; i<=19; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=19; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        int r = 0;
        int c =0;
        a : for(int i=1; i<20; i++){
            for(int j=1; j<20; j++){
                if(grid[i][j] == 0) continue;
                ans = isWin(i, j, grid[i][j]);
                if(ans != 0){
                    r = i;
                    c = j;
                    break a;
                }
            }
        }
        System.out.println(ans);
        if(ans != 0){
            System.out.printf("%d %d", r, c);
        }
    }

    static int isWin(int r, int c, int color){
        for(int i=0; i<DIR_NUM; i++) {
            int cnt = 1;
            int x = r;
            int y = c;
            while(true) {
                int nx = x + dxs[i];
                int ny = y + dys[i];
                if(canGo(nx, ny, color)){
                    int rx = r - dxs[i];
                    int ry = c - dys[i];
                    if(grid[rx][ry] == color) return 0;
                    x = nx;
                    y = ny;
                    cnt++;
                }else break;
            }
            if(cnt == 5) {
                return color;
            }
        }
        return 0;
    }

    static boolean inRange(int x, int y){
        return x >= 0 && x < 21 && y >= 0 && y < 21;
    }

    static boolean canGo(int x, int y, int color){
        if(inRange(x, y) && grid[x][y] == color){
            return true;
        }
        return false;
    }
}
