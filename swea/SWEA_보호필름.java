import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_보호필름 {
    static int T;
    static int D, W, K;
    static int[][] grid;
    static StringTokenizer st;
    static int medicine;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            grid = new int[D][W];
            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            medicine = K; // 약물의 최대 개수를 K로 설정
            subSet(0, 0);
            System.out.println("#" + tc + " " + medicine);
        }
    }

    private static boolean canPass() {
        for (int j = 0; j < W; j++) {
            // 시작 인덱스(i)부터 i+K 까지의 합이 0또는 K가 되면 연속되어 있다는 의미이다.
            int cur = grid[0][j]; // 현재 가리키는 값
            int conCnt = 1; // 연속 된 숫자이 개수
            for (int i = 1; i < D; i++) {
                if (conCnt == K)
                    break; // 연속되는 수의 개수가 K라면 break
                if (cur == grid[i][j]) { // 연속되는 경우
                    conCnt++;
                } else { // 연속되지 않을 경우
                    conCnt = 1;
                    cur = grid[i][j];
                }
            }
            if (conCnt != K)
                return false;
        }
        return true;
    }

    private static void subSet(int cnt, int choose) {
        // 선택한 개수가 K보다 크거나 같을때 or 선택한 수가 현재 최소 투여 수 보다 크거나 같을 경우 return
        if (choose >= K || choose >= medicine) {
            return;
        }

        if (canPass()) {
            medicine = Math.min(medicine, choose);
            return;
        }

        if (cnt == D) { // 높이 만큼 재귀가 돌았을 경우 재귀 종료
            return;
        }

        int[] arr = Arrays.copyOf(grid[cnt], W);
        // A 약물 투여
        for (int i = 0; i < W; i++) {
            grid[cnt][i] = 0;
        }
        subSet(cnt + 1, choose + 1);

        // B 약물 투여
        for (int i = 0; i < W; i++) {
            grid[cnt][i] = 1;
        }
        subSet(cnt + 1, choose + 1);

        // 약물 투여하지 않았을 때
        grid[cnt] = arr;
        subSet(cnt + 1, choose);
    }
}