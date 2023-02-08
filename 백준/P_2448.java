import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_2448 {

    static char[][] grid;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        grid = new char[N][2*N];
        for(int i=0; i<N; i++){
            for(int j=0; j<2*N; j++){
                grid[i][j] = ' ';
            }
        }

        printStar(0, 0, N);

        for(int i=0; i<N; i++){
            for(int j=0; j<2*N; j++){
                sb.append(grid[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void printStar(int x, int y, int n){
        if(n == 3){
            for(int i=0; i<n; i++){
                for(int j=n-1-i; j<n+i; j++){
                    if(i == 1 && j == 2){
                        continue;
                    }
                    grid[x+i][y+j] = '*';
                }
            }
        }else{
            printStar(x+n/2, y, n/2);
            printStar(x, y+n/2, n/2);
            printStar(x+n/2, y+n, n/2);
        }
    }
}
