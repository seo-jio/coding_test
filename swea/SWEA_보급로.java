import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SWEA_보급로 {
    static int T, N;
    static int DX, DY;
    static int[][] grid;
    static List<Edge>[][] adj;

    static class Edge {
        int x; // 도착 지점
        int y;
        int w;

        public Edge(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }

    static class Node implements Comparable<Node> {
        int x; // 도착 지점
        int y;
        int dis;

        public Node(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.dis, o.dis);
        }
    }

    static PriorityQueue<Node> pque;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            grid = new int[N][N];
            for (int i = 0; i < N; i++) {
                char[] chars = br.readLine().toCharArray();
                for (int j = 0; j < N; j++) {
                    grid[i][j] = chars[j] - '0';
                }
            }

            // 경로 저장
            adj = new List[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    adj[i][j] = new ArrayList<>();
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (!inRange(nx, ny))
                            continue;
                        adj[i][j].add(new Edge(nx, ny, grid[nx][ny]));
                    }
                }
            }

            DX = N - 1;
            DY = N - 1;
            sb.append("#").append(tc).append(" ").append(dijkstra()).append("\n");
        }
        System.out.println(sb);
    }

    private static int dijkstra() {
        int[][] distance = new int[N][N];
        int MM = Integer.MAX_VALUE / 1000;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                distance[i][j] = MM;
            }
        }

        pque = new PriorityQueue<>();
        pque.offer(new Node(0, 0, 0));
        distance[0][0] = 0;

        while (!pque.isEmpty()) {
            Node cur = pque.poll();
            int x = cur.x;
            int y = cur.y;
            int dis = cur.dis;
            if (x == DX && y == DY) {
                return distance[DX][DY];
            }
            if (distance[x][y] != dis)
                continue; // que에 남아있는 잔재 이므로 skip
            for (Edge next : adj[x][y]) {
                int result = distance[x][y] + next.w;
                if (distance[next.x][next.y] > result) {
                    distance[next.x][next.y] = result;
                    pque.offer(new Node(next.x, next.y, result));
                }
            }
        }
        return -1;
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
