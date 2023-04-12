import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_3055 {
    static int N, M;
    static char[][] grid;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int flag = 0;
    static int DR;
    static int DC;
    static Queue<Pair> hedges;
    static Queue<Pair> waters;

    static class Pair {
        int x;
        int y;
        int dis; // 이동 거리

        public Pair(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        grid = new char[N][M];
        for (int i = 0; i < N; i++) {
            grid[i] = br.readLine().toCharArray();
        }
        hedges = new LinkedList<>(); // 비버 위치 저장
        waters = new LinkedList<>(); // 물 위치 저장
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 'S') {
                    hedges.offer(new Pair(i, j));
                } else if (grid[i][j] == '*') {
                    waters.offer(new Pair(i, j));
                }
                if (grid[i][j] == 'D') {
                    DR = i;
                    DC = j;
                }
            }
        }

        while (true) {
            if (hedges.size() == 0) { // 비버가 더 이상 이동할 수 없는 경우
                System.out.println("KAKTUS");
                break;
            }
            bfsWater(); // 물 이동
            int cnt = bfsHedge(); // 비버 이동
            if (cnt > 0) {
                System.out.println(cnt);
                break;
            }
        }
    }

    private static int bfsHedge() { // 비버 이동
        int size = hedges.size(); // 초키 큐 사이즈 만큼 while문이 돌도록 수행
        while (size-- > 0) {
            Pair cur = hedges.poll();
            int x = cur.x;
            int y = cur.y;
            int dis = cur.dis;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (!inRange(nx, ny))
                    continue;
                if (nx == DR && ny == DC) { // 도착 지점에 도달한 경우
                    return dis + 1;
                }
                if (grid[nx][ny] == '.') { // 이동할 수 있는 경우
                    grid[nx][ny] = 'S';
                    hedges.offer(new Pair(nx, ny, dis + 1));
                }
            }
        }
        return -1;
    }

    private static void bfsWater() { // 물 이동
        int size = waters.size();
        while (size-- > 0) {
            Pair cur = waters.poll();
            int x = cur.x;
            int y = cur.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (!inRange(nx, ny))
                    continue;
                if (grid[nx][ny] == '.' || grid[nx][ny] == 'S') { // 길이거나 비버일 경우
                    grid[nx][ny] = '*';
                    waters.offer(new Pair(nx, ny)); // 물은 굳이 이동 거리를 저장할 필요가 없다.
                }
            }
        }
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}