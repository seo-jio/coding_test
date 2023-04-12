import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_12015 {
    static int N;
    static int[] nums;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // i : 최장증가부분 수열의 길이, dp[i] : 최장증가부분수열의 길이가 i를 만족시키는 값 중 최소 값
        dp = new int[N + 1];
        int size = 0;
        for (int i = 0; i < N; i++) { // nums 배열을 순회하며 dp 테이블에 값을 갱신
            int index = Arrays.binarySearch(dp, 0, size, nums[i]); // 숫자가 dp 배열의 어느 index에 들어가야 하는 지 이진탐색을 활용하여 검색
            System.out.println("index : " + index);
            if (index == 0)
                continue;
            index = Math.abs(index) - 1; // 삽입해야할 위치
            dp[index] = nums[i];

            if (size == index) { //
                size += 1;
            }
        }

        System.out.println(size);
    }
}
