import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_11279 {
    static PriorityQueue<Integer> pque;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pque = new PriorityQueue<>((x, y) -> Integer.compare(x, y));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0 && pque.isEmpty()) {
                sb.append(0).append("\n");
                continue;
            }
            if (num == 0 && !pque.isEmpty()) {
                sb.append(pque.poll()).append("\n");
                continue;
            }
            pque.offer(num);
        }
        System.out.println(sb);
    }
}
