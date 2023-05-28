import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10994 {

    static int N;
    static char[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int n = 1 + (N-1) * 4;
        grid = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                grid[i][j] = ' ';
            }
        }
        printStar(0, 0, N);

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    static void printStar(int r, int c, int N){
        if(N == 1){
            grid[r][c] = '*';
            return;
        }
        int n = 1 + (N-1) * 4;
        for(int i=r; i<n+r; i++){
            for(int j=c; j<n+c; j++){
                if(i == r || i == r + n-1 || j == c || j == c + n-1){
                    grid[i][j] = '*';
                }
            }
        }
        printStar(r+2, c+2, N-1);
    }
}
