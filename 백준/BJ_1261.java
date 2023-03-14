import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1261 {
    static int N, M, min;
    static int MM = Integer.MAX_VALUE / 1000;
    static int[][] grid;
    static int[][] distance;
    static List<Edge>[][] adj;
    static class Edge implements Comparable<Edge>{
        int x;
        int y;
        int w;

        public Edge(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }
    static PriorityQueue<Edge> pque;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        grid = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                grid[i][j] = chars[j] - '0';
            }
        }

        adj = new List[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                adj[i][j] = new ArrayList<>();
            }
        }

        //간선 정보 입력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for(int d = 0; d<4; d++){
                    int nx = i + dx[d];
                    int ny = j + dy[d];
                    if(inRange(nx, ny)){
                        adj[i][j].add(new Edge(nx, ny, grid[nx][ny]));
                    }
                }
            }
        }

        dijkstra();
        System.out.println(distance[N-1][M-1]);
    }

    private static boolean inRange(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    private static void dijkstra(){
        pque = new PriorityQueue<>();
        pque.add(new Edge(0, 0, 0));
        distance = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(distance[i], MM);
        }
        distance[0][0] = 0;

        while(!pque.isEmpty()){
            Edge cur = pque.poll();
            int x = cur.x;
            int y = cur.y;
            int w = cur.w;
            if(x == N-1 && y == M-1) {
                return;
            }
            if(distance[x][y] != w) continue;
            for(Edge e : adj[x][y]){
                int nx = e.x;
                int ny = e.y;
                int nw = e.w;
                int result = distance[x][y] + nw;
                if(distance[nx][ny] > result){
                    distance[nx][ny] = result;
                    pque.offer(new Edge(nx, ny, result));
                }
            }
        }
    }
}
