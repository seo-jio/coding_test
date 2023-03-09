import java.io.*;
import java.util.*;

public class SWEA_달팽이 {
    static int[][] grid;
    static int N;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int DIR_NUM;
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<= T; tc++){
            N = Integer.parseInt(br.readLine());
            grid = new int[N][N];
            DIR_NUM = 0;     //DIR_NUM을 test case마다 초기화 해줘야 함

            int x = 0;
            int y= 0;
            grid[x][y] = 1;
            for(int i=2; i<= N*N; i++){
                int nx = x + dx[DIR_NUM];
                int ny = y + dy[DIR_NUM];
                if(!inRange(nx, ny) || grid[nx][ny] != 0){ //범위를 벗어나거나 이미 방문했던 곳이라면 방향을 전환
                    DIR_NUM = (DIR_NUM + 1) % 4;           //시계 방향으로 90도 전환
                    nx = x + dx[DIR_NUM];
                    ny = y + dy[DIR_NUM];
                }
                x = nx;
                y = ny;
                grid[x][y] = i;
            }

            StringBuilder sb = new StringBuilder();
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    sb.append(grid[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.printf("#%d\n", tc);
            System.out.printf("%s", sb.toString());
        }

    }

    static boolean inRange(int x, int y){
        return x>=0 && x<N && y>=0 && y<N;
    }
}