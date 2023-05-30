import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.MappedByteBuffer;
import java.util.StringTokenizer;

//구간 합
public class BJ_11660 {
    static int N, M;
    static int[][] grid;
    static int[][] sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N+1][N+1];
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N+1; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //구간 합 저장할 sum 배열 초기화
        sum = new int[N+1][N+1];
        sum[1][1] = grid[1][1];
        for (int i = 2; i < N+1; i++) {
            sum[1][i] = sum[1][i-1] + grid[1][i];
            sum[i][1] = sum[i-1][1] + grid[i][1];
        }
        for (int i = 2; i < N+1; i++) {
            for (int j = 2; j < N+1; j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + grid[i][j];
            }
        }

        //구간 합 구하기
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int nx = Integer.parseInt(st.nextToken());
            int ny = Integer.parseInt(st.nextToken());
            sb.append(sum[nx][ny] - sum[x-1][ny] - sum[nx][y-1] + sum[x-1][y-1]).append("\n");
        }
        System.out.println(sb);
    }
}