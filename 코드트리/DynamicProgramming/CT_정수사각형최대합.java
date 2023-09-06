import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CT_정수사각형최대합 {
    static int N;
    static int[][] grid;
    static int[][] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        memo = new int[N][N];
        grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //1. 초기화
        memo[0][0] = grid[0][0];

        for (int i = 1; i < N; i++) { //0번째 열 초기화
            memo[i][0] = memo[i-1][0] + grid[i][0];
        }

        for (int i = 1; i < N; i++) {
            memo[0][i] = memo[0][i-1] + grid[0][i];
        }

        //2. dp
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]) + grid[i][j];
            }
        }

        System.out.println(memo[N-1][N-1]);

    }
}
