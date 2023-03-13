import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_4485 {
    static int N;
    static int MM = Integer.MAX_VALUE / 1000;
    static int[][] grid;
    static int[][] distance;

    static List<Edge>[][] adj;
    static class Edge{
        int x, y, w;

        public Edge(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }
    static class Element implements Comparable<Element>{
        int x, y, w;

        public Element(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.w = dis;
        }

        @Override
        public int compareTo(Element o) {
            return Integer.compare(this.w, o.w);
        }
    }
    static PriorityQueue<Element> pque;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int desX; //도착 지점
    static int desY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        while(true){
            cnt++;
            N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            grid = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            adj = new ArrayList[N][N]; //2차원 배열임에 유의
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    adj[i][j] = new ArrayList<>();
                }
            }
            for (int i = 0; i < N; i++) { //사방 탐색하며 간선 정보 입력
                for (int j = 0; j < N; j++) {
                    for(int d = 0; d < 4; d++){
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if(inRange(nx, ny)){
                            adj[i][j].add(new Edge(nx, ny, grid[nx][ny]));
                        }
                    }
                }
            }

            desX = N-1; //도착지 설정
            desY = N-1;
            distance = new int[N][N]; //거리 배열 초기화
            for (int i = 0; i < N; i++) {
                Arrays.fill(distance[i], MM);
            }
            distance[0][0] = grid[0][0]; //초기값 설정

            pque = new PriorityQueue<>();
            pque.offer(new Element(0, 0, grid[0][0]));
            dijkstra();

            sb.append("Problem ").append(cnt).append(": ").append(distance[N-1][N-1]).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean inRange(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    private static void dijkstra(){
        while(!pque.isEmpty()){
            Element cur = pque.poll();
            int sx = cur.x;
            int sy = cur.y;
            int w = cur.w;
            if(sx == desX && sy == desY) return; //도착점에 도달했을 경우 return
            if(distance[sx][sy] != w) continue; //이 경우 방문했던 노드(pque에 남은 잔재)임을 의미하므로 continue
            for(Edge e : adj[sx][sy]){ //인접한 간선을 확인하며 distance 배열 갱신
                int nx = e.x;
                int ny = e.y;
                int nw = e.w;
                int newDis = distance[sx][sy] + nw;
                if(distance[nx][ny] > newDis){ //이 조건문으로 방문한 노드는 다시 방문하지 않는다.(양의 가중치만 존재하기 때문에 경유할 경우 무조건 거리가 늘어난다.)
                    distance[nx][ny] = newDis;
                    pque.offer(new Element(nx ,ny, newDis));
                }
            }
        }
    }
}