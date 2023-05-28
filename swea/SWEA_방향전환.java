import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_방향전환 {
    static int T;
    static boolean[][][] visited;
    static int sx, sy, ex, ey;
    static int ans;
    static Queue<Pair> que;

    static class Pair {
        int x, y, dir, dis;

        public Pair(int x, int y, int dir, int dis) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.dis = dis;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sx = Integer.parseInt(st.nextToken()) + 100;
            sy = Integer.parseInt(st.nextToken()) + 100;
            ex = Integer.parseInt(st.nextToken()) + 100;
            ey = Integer.parseInt(st.nextToken()) + 100;

            visited = new boolean[202][202][2];
            que = new LinkedList<>();
            que.offer(new Pair(sx, sy, 0, 0)); // 가로
            que.offer(new Pair(sx, sy, 1, 0));
            ans = Integer.MAX_VALUE;
            bfs();

            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs() {
        while (!que.isEmpty()) {
            Pair cur = que.poll();
            int x = cur.x;
            int y = cur.y;
            int dir = cur.dir;
            if (x == ex && y == ey) {
                ans = Math.min(ans, cur.dis);
                continue;
            }
            int nx = 0;
            int ny = 0;
            if (dir == 0) { // 이전에 가로로 이동했어
                if (y <= ey) {
                    ny = y + 1;
                } else {
                    ny = y - 1;
                }
                nx = x;
            } else {
                if (x <= ex) {
                    nx = x + 1;
                } else {
                    nx = x - 1;
                }
                ny = y;
            }
            if (!visited[nx][ny][1 - dir]) {
                visited[nx][ny][1 - dir] = true;
                que.offer(new Pair(nx, ny, 1 - dir, cur.dis + 1));
            }
        }
    }
}
