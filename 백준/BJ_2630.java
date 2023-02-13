import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2630 {
    static int[][] grid;
    static int N;
    static int white = 0; // 흰 색종이 수
    static int blue = 0; // 파랑색 색종이 수
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
        solve(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }

    public static boolean isSame(int x, int y, int size){ // 색이 통일되어있는지 확인
        boolean flag = true;
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(grid[x+i][y+j] != grid[x][y]) {
                    flag = false;
                }
            }
        }
        return flag;
    }

    public static void solve(int x, int y, int size){
        if(isSame(x, y, size) || size == 1){ // 종료 조건 : 같은 색깔이냐 or 1칸 짜리냐
            if(grid[x][y] == 0){
                white += 1;
            }else{
                blue += 1;
            }
        }else{                              // 각 사분면의 시작점 지정
            solve(x, y, size/2);
            solve(x, y+size/2, size/2);
            solve(x+size/2, y, size/2);
            solve(x+size/2, y+size/2, size/2);
        }
    }
}
