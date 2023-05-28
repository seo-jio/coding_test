import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2638 {
    static int N;
    static int M;
    static int[][] grid;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int totCnt;  //시뮬레이션 횟수
    static int meltCnt;  //녹은 치즈의 개수
    static class Pair{   //bfs 때 활용할 x,y쌍
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Queue<Pair> queue;

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while (isExist()){
            simulate();
        }
        System.out.println(totCnt);
    }

    private static void simulate() {
        totCnt++;  //시뮬레이션 횟수 증가
        meltCnt = 0;
        init();
        bfs();
        melt();
    }

    private static void melt() { //공기와 2개 이상 닿아있는 치즈를 녹임
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(grid[i][j] == 1){
                    int cnt = 0;
                    int x = i;
                    int y = j;
                    for(int d=0; d<4; d++){
                        int nx = x + dx[d];
                        int ny = y + dy[d];
                        if(grid[nx][ny] == 0 && visited[nx][ny]) cnt++;
                    }
                    if(cnt >= 2){
                        grid[i][j] = 0;
                    }
                }
            }
        }
    }

    private static void init(){  //BFS를 위한 초기화
        visited = new boolean[N][M];
        visited[0][0] = true;
        queue = new LinkedList<>();
        queue.offer(new Pair(0, 0));
    }

    private static boolean inRange(int x, int y){ //격자 내인지 판단
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    private static boolean canGo(int x, int y){  //갈 수 있는 곳인지 판단
        if(inRange(x, y) && grid[x][y] == 0 && !visited[x][y]){
            return true;
        }
        return false;
    }

    private static void bfs(){   //bfs
        while(!queue.isEmpty()){
            Pair cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(canGo(nx, ny)){
                    visited[nx][ny] = true;
                    queue.offer(new Pair(nx, ny));
                    meltCnt++;  //녹은 치즈 개수 증가
                }
            }
        }
    }

    private static boolean isExist(){ //격자 내 치즈가 존재하는 지 확인
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(grid[i][j] == 1){
                    return true;
                }
            }
        }
        return false;
    }
}
