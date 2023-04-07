import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2042_SegmentTree {
    static int N, M, K;
    static int[] nums;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        tree = new long[N * 4];
        build(1, 0, N - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 1) {
                update(b - 1, c, 1, 0, N - 1);
            } else {
                long ans = query(b - 1, c - 1, 1, 0, N - 1);
                sb.append(ans).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static long build(int node, int nodeLeft, int nodeRight) {
        if (nodeLeft == nodeRight) {
            return tree[node] = nums[nodeLeft];
        }
        int mid = nodeLeft + (nodeRight - nodeLeft) / 2;
        long leftValue = build(node * 2, nodeLeft, mid);
        long rightValue = build(node * 2 + 1, mid + 1, nodeRight);
        return tree[node] = leftValue + rightValue;
    }

    private static long update(int index, int newValue, int node, int nodeLeft, int nodeRight) {
        if (nodeRight < index || index < nodeLeft) {
            return tree[node];
        }
        if (nodeLeft == nodeRight) {
            return tree[node] = newValue;
        }
        int mid = nodeLeft + (nodeRight - nodeLeft) / 2;
        long leftValue = update(index, newValue, node * 2, nodeLeft, mid);
        long rightValue = update(index, newValue, node * 2 + 1, mid + 1, nodeRight);
        return tree[node] = leftValue + rightValue;
    }

    private static long query(int left, int right, int node, int nodeLeft, int nodeRight) {
        if (nodeRight < left || right < nodeLeft) {
            return 0;
        }
        if (left <= nodeLeft && nodeRight <= right) {
            return tree[node];
        }
        int mid = nodeLeft + (nodeRight - nodeLeft) / 2;
        long leftValue = query(left, right, node * 2, nodeLeft, mid);
        long rightValue = query(left, right, node * 2 + 1, mid + 1, nodeRight);
        return leftValue + rightValue;
    }
}
