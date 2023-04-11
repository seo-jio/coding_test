import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class BJ_1922 {
    static int N;
    static int M;

    static class Edge implements Comparable<Edge> {
        int v;
        int w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "v=" + v +
                    ", w=" + w +
                    '}';
        }
    }

    static List<Edge>[] graph;
    static int minSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[s].add(new Edge(e, w));
            graph[e].add(new Edge(s, w));
        }

        minSum = 0;
        prim(1);
        System.out.println(minSum);
    }

    private static void prim(int start) {
        Queue<Edge> pque = new PriorityQueue<>();
        pque.add(new Edge(start, 0));
        boolean[] visited = new boolean[N + 1];

        while (!pque.isEmpty()) {
            Edge cur = pque.poll();
            int v = cur.v;
            int w = cur.w;
            if (visited[v])
                continue; // 큐에 여러개가 들어가 있을 수 있으므로 방문 체크
            visited[v] = true;
            minSum += w; // 비용 갱신
            for (Edge e : graph[v]) { // 선택된 노드와 인접합 노드들을 pque에 넣어준다.
                if (visited[e.v])
                    continue; // 이미 방문한 노드는 넘어감
                pque.offer(e);
            }
        }
    }
}
