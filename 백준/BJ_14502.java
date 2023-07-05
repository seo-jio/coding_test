import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_14502 {
    static int N, M;
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] grid = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }



        //1. 벽을 세울 위치를 조합을 사용해 지정
        int ans = Integer.MIN_VALUE;
        Point[] walls = new Point[3];
        for (int i = 0; i < N*M; i++) {
            for (int j = i+1; j < N*M; j++) {
                for (int k = j+1; k < N*M; k++) {
                    walls[0] = numToPoint(i);
                    walls[1] = numToPoint(j);
                    walls[2] = numToPoint(k);
//                    System.out.println("==============");
                    ans = Math.max(ans, simulation(makeCopy(grid), walls));
                }
            }
        }
        System.out.println(ans);
    }

    private static int[][] makeCopy(int[][] grid) {
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            copy[i] = Arrays.copyOfRange(grid[i], 0, M);
        }
        return copy;
    }

    private static int simulation(int[][] grid, Point[] walls) {
        //1. 격자에 벽을 그림
        for (int i = 0; i < 3; i++) {
            int wallX = walls[i].x;
            int wallY = walls[i].y;
            if(grid[wallX][wallY] == 2 || grid[wallX][wallY] == 1){ //벽을 설치하려는 위치에 바이러스가 있는 경우
                return -1;
            }
            grid[wallX][wallY] = 1;
        }

        //2. 바이러스를 퍼뜨림
        boolean[][] visited = new boolean[N][M];
        Queue<Point> que = new LinkedList<>();
        for (int i = 0; i < N; i++) { //바이러스가 있는 좌표를 큐에 넣어주고 방문 처리
            for (int j = 0; j < M; j++) {
                if(grid[i][j] == 2){
                    visited[i][j] = true;
                    que.offer(new Point(i, j));
                }
            }
        }
        while (!que.isEmpty()) {
            Point cur = que.poll();
            int x = cur.x;
            int y = cur.y;
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(!inRange(nx, ny) || visited[nx][ny] || grid[nx][ny] == 1) continue;
                visited[nx][ny] = true;
                grid[nx][ny] = 2;
                que.offer(new Point(nx, ny));
            }
        }


        //3. 안전 영역 계산
        int safeCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(grid[i][j] == 0){
                    safeCnt += 1;
                }
            }
        }

        return safeCnt;
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    private static Point numToPoint(int num){
        int x = num / M;
        int y = num % M;
        return new Point(x, y);
    }

}
