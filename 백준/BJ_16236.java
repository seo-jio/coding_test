import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16236 {
    static int N, time;
    static int[][] grid;
    static int[][] distance;
    static boolean[][] canGo;
    static Shark baby;
    static class Shark {
        int x, y; //현재 위치
        int cnt = 0; //먹은 물고기 개수
        int size = 2; //크기

        public Shark(int x, int y, int cnt, int size) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.size = size;
        }

        public void eat(Pair fish){
            //상어를 물고기 위치로 이동
            grid[baby.x][baby.y] = 0;
            baby.x = fish.x;
            baby.y = fish.y;
            grid[baby.x][baby.y] = 9;
            cnt++; //먹은 물고기 개수 증가

            if(cnt == size){ //먹은 물고기 개수가 자신의 size와 같다면 cnt 초기화 및 size 증가
                cnt = 0;
                size++;
            }
        }
    }
    static class Pair{
        int x, y;
        int dis; //이동 거리

        public Pair(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if(grid[i][j] == 9){
                    baby = new Shark(i, j, 0, 2);
                    grid[i][j] = 0;
                }
            }
        }

        time = 0;
        while(true){
            bfs();  //상어와 물고기 간의 거리 계산
            Pair fish = findNear(); //상어와 가장 가까운 물고기 찾기
            if(fish == null) break;
            time += fish.dis;
            baby.eat(fish);
        }
        System.out.println(time);
    }

    private static Pair findNear() {
        Pair fish = null;
        int minDis = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int cur = grid[i][j];
                int dis = distance[i][j];
                if(cur == 0 || cur == 9) continue; //물고기가 아닌 경우
                if(cur >= baby.size) continue; //상어보다 크기가 크거나 같은 경우
                if(!canGo[i][j]) continue; //상어가 방문할 수 없는 경우
                if(dis < minDis) { //상어와 더 가까운 물고기인 경우
                    fish = new Pair(i, j, dis);
                    minDis = dis;
                }
            }
        }
        return fish;
    }

    private static void bfs() { //상어와 물고기들 간의 거리를 계산
        Queue<Pair> que = new ArrayDeque<>();
        que.offer(new Pair(baby.x, baby.y, 0));
        distance = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(distance[i], -1);
        }
        distance[baby.x][baby.y] = 0;
        canGo = new boolean[N][N];

        while (!que.isEmpty()){
            Pair cur = que.poll();
            int x = cur.x;
            int y = cur.y;;
            for (int d = 0; d <4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(!inRange(nx, ny)) continue;
                if(baby.size < grid[nx][ny]) continue; //자신보다 큰 물고기라면
                if(distance[nx][ny] == -1){ //방문하지 않은 곳이면
                    distance[nx][ny] = cur.dis + 1;
                    canGo[nx][ny] = true;
                    que.offer(new Pair(nx, ny, cur.dis+1));
                }
            }
        }
    }

    private static boolean inRange(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}