import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//북마크에 코딩테스트 폴더에 Fenwick Tree 설명 확인
public class BJ_2042_FenwickTree {
    static int N, M, K;
    static long[] nums;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nums = new long[N + 1];
        tree = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            nums[i] = Long.parseLong(br.readLine());
            update(i, nums[i]); // 트리 초기화
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 1) {
                long c = Long.parseLong(st.nextToken());
                long diff = c - nums[b];
                nums[b] = c;
                update(b, diff); // 차이를 update의 인자로 넣어줌
            } else {
                int c = Integer.parseInt(st.nextToken());
                long ans = query(c) - query(b - 1);
                sb.append(ans).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void update(int pos, long val) {
        while (pos < tree.length) {
            tree[pos] += val;
            pos += (pos & -pos);
        }
    }

    private static long query(int pos) {
        long result = 0;
        while (pos > 0) {
            result += tree[pos];
            pos &= (pos - 1);
        }
        return result;
    }
}
