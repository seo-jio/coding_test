import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1992 {
    static int N;
    static int[][] grid;
    static StringTokenizer st;
    static String str = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        for(int i=0; i<N; i++){
            String[] arr = br.readLine().split("");
            for(int j=0; j<N; j++){
                grid[i][j] = Integer.parseInt(arr[j]);
            }
        }
        solve(0, 0, N);
        System.out.println(str);
    }

    private static void solve(int x, int y, int size){
        if(canCompress(x, y, size)){
            str += grid[x][y];
            return;
        }
        int half = size/2;
        str += "(";
        solve(x, y, half);
        solve(x, y+half, half);
        solve(x+half, y, half);
        solve(x+half, y+half, half);
        str += ")";
    }

    private static boolean canCompress(int x, int y, int size){
        int start = grid[x][y];
        for(int i=x; i<x+size; i++){
            for(int j=y; j<y+size; j++){
                if(grid[i][j] != start){
                    return false;
                }
            }
        }
        return true;
    }
}
