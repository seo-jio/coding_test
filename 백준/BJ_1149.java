import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1149 {
    static int N;
    static int[][] memo; //row : 집 번호, col : 색깔을 의미한다.
    static int[][] weights;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        memo = new int[N][3];
        weights = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                weights[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 3; i++) { //memo 초기화
            memo[0][i] = weights[0][i];
        }

        for (int i = 1; i <= N-1; i++) { //이전 행(집)에 열(색)이 다른 것 중 최솟 값을 memo에 저장
            for (int j = 0; j < 3; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < 3; k++) {
                    if(j == k) continue;
                    min = Math.min(min, memo[i - 1][k]);
                }
                memo[i][j] = weights[i][j] + min;
            }
        }

        int ans = Arrays.stream(memo[N-1]).min().getAsInt();
        System.out.println(ans);
    }
}