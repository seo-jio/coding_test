import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//이 문제는 왼쪽으로 못가기 때문에 방문 배열 처리가 꼭 필요하진 않다.
public class BJ_17070 {
    static int N;
    static int[][] grid;
    static boolean[][] visited;
    static int possibleCnt;
    static int[] dx = { 0, 1, 1 }; // index가 곧 상태이다!(0:가로, 1: 새로, 2:대각선)
    static int[] dy = { 1, 0, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[N][N];
        visited[0][1] = true;
        possibleCnt = 0;
        dfs(0, 1, 0);
        System.out.println(possibleCnt);
    }

    private static void dfs(int x, int y, int dir) {
        for (int d = 0; d < 3; d++) {
            if (dir == 0 && d == 1)
                continue;
            if (dir == 1 && d == 0)
                continue;
            int nx = x + dx[d];
            int ny = y + dy[d];

            // 범위안에 안들거나, 방문했거나, 갈수 없다면 continue
            if (!inRange(nx, ny) || visited[nx][ny] || !canGo(nx, ny, d)) {
                continue;
            }

            if (nx == N - 1 && ny == N - 1) { // 도착지에 도달했을 경우
                possibleCnt += 1;
                return;
            }

            visited[nx][ny] = true; // 방문 처리했다가 다시 돌아오면 지워줘야함에 유의
            dfs(nx, ny, d);
            visited[nx][ny] = false;
        }
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    private static boolean canGo(int x, int y, int dir) {
        switch (dir) {
            case 0:
            case 1:
                if (grid[x][y] == 1) { // 이동하려는 방향이 가로 or 새로인 경우
                    return false;
                }
                break;
            case 2:
                if (grid[x][y] == 1 || grid[x - 1][y] == 1 || grid[x][y - 1] == 1) { // 이동하려는 방향이 대각선인 경우
                    return false;
                }
                break;
        }
        return true;
    }

}
