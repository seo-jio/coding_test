import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10997 {

    static int N;
    static char[][] grid;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new char[3+(N-1)*4][1+(N-1)*4];
        for(int i=0; i<3+(N-1)*4; i++){
            for(int j=0; j<1+(N-1)*4; j++){
                grid[i][j] = ' ';
            }
        }
        if(N==1){
            System.out.println('*');
        }
        else {
            printStar(0, 1+(N-1)*4-1, N);
            for(int i=0; i<3+(N-1)*4; i++){
                for(int j=0; j<1+(N-1)*4; j++){
                    if(i == 1 && j > 0){  //불필요한 공백 제거!!
                        continue;
                    }
                    System.out.print(grid[i][j]);
                }
                System.out.println();
            }
        }
    }
    static void printStar(int r, int c, int N){
        int width = 1+(N-1)*4;
        int height = 3+(N-1)*4;
        for(int i=c; i>c-width; i--){  //위,아래있는 가로 별
            grid[r][i] = '*';
            grid[r+height-1][i] = '*';
        }
        for(int i=0; i<height; i++){  //왼쪽 세로 별
            grid[r+i][c-width+1] = '*';
        }

        for(int i=2; i<height; i++){  //오른쪽 세로 별
            grid[r+i][c] = '*';
        }
        grid[r+2][c-1] = '*';  //별 하나 추가
        if(N == 2){  //n==2일 경우 세로로 별 세개 추가
            for(int i=0; i<3; i++){
                grid[r+2+i][c-2] = '*';
            }
            return;
        }
        printStar(r+2, c-2, N-1);

    }
}
