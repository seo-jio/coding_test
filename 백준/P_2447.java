import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_2447 {
    static String[][] grid;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        grid = new String[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                grid[i][j] = " ";
            }
        }
        printStar(0, 0, N);

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                sb.append(grid[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void printStar(int x, int y, int n) {
        if(n == 3){
            for(int i=0; i<3; i++) {
                for (int j=0; j<3; j++) {
                    if (i == 1 && j == 1) {
                        continue;
                    }
                    grid[x+i][y+j] = "*";
                }
            }
        }else{
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    if(i == 1 && j == 1){
                        continue;
                    }
                    printStar(x+n/3*i, y+n/3*j, n/3);
                }
            }
        }
    }
}
