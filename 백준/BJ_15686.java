import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_15686 {
    static int N, M;
    static int minDis;
    static int[][] grid;
    static int[][] visited; //최소 거리를 저장할 배열
    static List<Pair> chickens; //선택할 치킨 집을 저장할 배열
    static List<Pair> homes; //집에 위치를 저장할 배열
    static Pair[] nums;
    static Queue<Pair> que;
    static class Pair{
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N][N];
        chickens = new ArrayList<>();
        homes = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if(grid[i][j] == 1) homes.add(new Pair(i, j));
                else if(grid[i][j] == 2) chickens.add(new Pair(i, j));
            }
        }
        nums = new Pair[M];
        minDis = Integer.MAX_VALUE;
        comb(0, 0);
        System.out.println(minDis);
    }

    private static void comb(int cnt, int start) { //nCr, n:치킨집 수, r:M
        if(cnt == M){
            que = new ArrayDeque<>();
            visited = new int[N][N];
            for(int i=0; i<M; i++){ //치킨집들을 que에 추가 및 방문처리
                que.offer(nums[i]);
                visited[nums[i].x][nums[i].y] = 1;
            }
            bfs();
            //치킨 거리 계산
            int sum = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(grid[i][j] == 1) sum+=visited[i][j]-1;
                }
            }
            //최소 치킨 거리 갱신
            minDis = Math.min(minDis, sum);
            return;
        }
        for(int i=start; i<chickens.size(); i++){
            nums[cnt] = chickens.get(i);
            comb(cnt+1, i+1);
        }
    }

    private static void bfs(){
        while (!que.isEmpty()) {
            Pair cur = que.poll();
            int x = cur.x;
            int y = cur.y;
            int dis = visited[x][y];
            for(int d=0; d<4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(inRange(nx, ny) && visited[nx][ny] == 0){ //거리 갱신
                    visited[nx][ny] = dis+1;
                    que.offer(new Pair(nx, ny));
                }
            }
        }
    }

    private static boolean inRange(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
