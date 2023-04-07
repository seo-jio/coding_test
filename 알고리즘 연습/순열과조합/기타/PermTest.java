package 기타;

import java.util.Arrays;

//nPr
public class PermTest {
    static int[] p = { 1, 2, 3, 4, 5 };
    static int N = p.length;
    static int R;
    static int[] nums;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) {
        R = 3;
        nums = new int[R];
        visited = new boolean[N];
        count = 0;
        perm(0);
        System.out.println(count);
    }

    static void perm(int cnt) {
        if (cnt == R) {
            count++;
            System.out.println(Arrays.toString(nums));
            return;
        }
        // 선택한 수들 중 겹치는 게 없도록 방문 배열을 사용한다.
        // 2 1 3과 1 2 3이 다르기 때문에 for문이 매번 0부터 주어진 범위(N)까지 돌게 된다.
        for (int i = 0; i < N; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            nums[cnt] = p[i];
            perm(cnt + 1);
            nums[cnt] = 0;
            visited[i] = false;
        }
    }
}