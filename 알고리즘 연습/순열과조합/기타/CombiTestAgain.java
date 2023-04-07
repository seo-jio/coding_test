package 기타;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CombiTestAgain {

    static int[] p = { 1, 2, 3, 4, 5, 6 };
    static int N = p.length;
    static int R;
    static int totCnt;
    static int[] nums;
    static boolean[] visited;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        R = 3;
        nums = new int[R];
        visited = new boolean[N];

        comb(0, 0);
        System.out.printf("cnt : %d", totCnt);
    }

    public static void comb(int cnt, int start) {
        if (cnt == R) {
            totCnt++;
            System.out.println(Arrays.toString(nums));
            return;
        }
        for (int i = start; i < N; i++) {
            visited[i] = true;
            nums[cnt] = p[i];
            comb(cnt + 1, i + 1);
            visited[i] = false;
        }
    }
}
