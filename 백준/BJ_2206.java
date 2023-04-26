import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2206 {
    static int N, M, minDis;
    static int[][] grid;
    static boolean[][][] visited;
    static Queue<Pair> que;
    static class Pair{
        int x, y, dis;
        int canBreak; // 0 : 이미 부순 경우, 1 : 부술 수 있는 경우

        public Pair(int x, int y, int dis, int canBreak) {
            this.x = x;
            this.y = y;
            this.dis = dis;
            this.canBreak = canBreak;
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                grid[i][j] = chars[j] - '0';
            }
        }

        minDis = Integer.MAX_VALUE;
        bfs();

        if (minDis == Integer.MAX_VALUE) {
            System.out.println(-1);
        }else{
            System.out.println(minDis);
        }

    }

    private static void bfs() {
        visited = new boolean[N][M][2]; // 방문배열을 3차원으로 설정하여 특정 위치를 벽을 이미 부수고 온 경우와 벽을 부수지 않고 온 경우 두 가지로 구분한다.
        que = new ArrayDeque<>();
        visited[0][0][0] = true;
        visited[0][0][1] = true;
        que.offer(new Pair(0, 0, 1, 1));

        while (!que.isEmpty()) {
            Pair cur = que.poll();
            int x = cur.x;
            int y = cur.y;
            int dis = cur.dis;
            int canBreak = cur.canBreak;

            if (x == N - 1 && y == M - 1) { // 도착지에 도달한 경우 값 갱신
                minDis = dis;
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (!inRange(nx, ny)) { // 격자를 벗어나는 경우
                    continue;
                }

                if(visited[nx][ny][canBreak]){ // 방문한 경우
                    continue;
                }

                if (grid[nx][ny] == 1 && canBreak == 0) { // 벽이면서 이미 벽을 부순적이 있는 경우
                    continue;
                }

                if (grid[nx][ny] == 1) { // 벽이면서 벽을 부순적이 없는 경우
                    que.offer(new Pair(nx, ny, dis + 1, 0));
                    continue;
                }

                visited[nx][ny][canBreak] = true; // 길인 경우
                que.offer(new Pair(nx, ny, dis + 1, canBreak));
            }
        }
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
