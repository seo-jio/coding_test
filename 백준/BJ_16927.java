import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//시뮬레이션
public class BJ_16927 {
    static int N;
    static int M;
    static int R;
    static int[][] grid;
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        grid = new int[N][M];
        for(int i=0; i< N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int min = Math.min(N, M);
        int add = 0;
        int sub = 0;
        for(int j=0; j<min/2; j++){ //겹만큼 회전
            int r = R %(2*(N-sub)+2*(M-sub)-4);  //몇 번 회전할지 계산
            for(int i=0; i<r; i++){
                rotate(0+add, 0+add, N-sub, M-sub);
            }
            add++; //모서리 증가
            sub += 2; //길이 감소
        }

        sb = new StringBuilder();
        for(int k=0; k<N; k++){
            for(int l=0; l<M; l++){
                sb.append(grid[k][l]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    //한 바퀴 돌리는 메소드
    //x, y 겹의 왼쪽 모서리 좌표
    //row, col 행과 열의 길이
    private static void rotate(int x, int y, int row, int col){
        int temp = grid[x][y];
        for(int i=y; i< y+col-1; i++){ //위쪽 행
            grid[x][i] = grid[x][i+1];
        }

        for(int i=x; i<x+row-1; i++){ //오른쪽 열
            grid[i][y+col-1] = grid[i+1][y+col-1];
        }

        for(int i=y+col-1; i>y; i--){ //아래쪽 행
            grid[x+row-1][i] = grid[x+row-1][i-1];
        }

        for(int i=x+row-1; i>x; i--){ //왼쪽 열
            grid[i][y] = grid[i-1][y];
        }
        grid[x+1][y] = temp;
    }
}