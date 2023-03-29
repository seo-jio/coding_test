import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_무선충전 {
    static int T, M, A;
    static int[] aArr, bArr;
    static int Ax, Ay;
    static int Bx, By;
    static int totSum;
    static int[] dx = { 0, -1, 0, 1, 0 };
    static int[] dy = { 0, 0, 1, 0, -1 };
    static TreeSet<BC>[][] grid; // 2차원으로 만든 뒤 추후 i, j 위치에 BC 클래스를 넣어준다.

    static class BC implements Comparable<BC> { // TreeSet을 사용
        int x;
        int y;
        int c; // 충전 범위
        int p; // 성능(충전량)

        public BC(int x, int y, int c, int p) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.p = p;
        }

        @Override
        public int compareTo(BC o) {
            return -Integer.compare(this.p, o.p);
        }

        @Override
        public boolean equals(Object o) { // set을 사용하기 위해 equals와 hashcode override
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            BC bc = (BC) o;
            return x == bc.x && y == bc.y && c == bc.c && p == bc.p;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, c, p);
        }
    }

    static BC[] chargers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            String[] temp = br.readLine().split(" ");
            M = Integer.parseInt(temp[0]);
            A = Integer.parseInt(temp[1]);
            aArr = new int[M];
            temp = br.readLine().split(" ");
            for (int i = 0; i < M; i++) {
                aArr[i] = Integer.parseInt(temp[i]);
            }
            bArr = new int[M];
            temp = br.readLine().split(" ");
            for (int i = 0; i < M; i++) {
                bArr[i] = Integer.parseInt(temp[i]);
            }
            chargers = new BC[A];
            for (int i = 0; i < A; i++) {
                temp = br.readLine().split(" ");
                chargers[i] = new BC(Integer.parseInt(temp[1]) - 1, Integer.parseInt(temp[0]) - 1,
                        Integer.parseInt(temp[2]), Integer.parseInt(temp[3]));
            }

            // 격자에 무선 충전기를 표시
            grid = new TreeSet[10][10];
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    grid[i][j] = new TreeSet<>();
                }
            }
            for (BC charger : chargers) {
                paint(charger);
            }
            // A, B 이동
            totSum = 0;
            Ax = 0;
            Ay = 0;
            Bx = 9;
            By = 9;
            charge(); // 초기 위치에 있을 때 충전
            for (int i = 0; i < M; i++) {
                Ax += dx[aArr[i]];
                Ay += dy[aArr[i]];
                Bx += dx[bArr[i]];
                By += dy[bArr[i]];
                charge(); // 이동 후 충전
            }
            sb.append("#").append(tc).append(" ").append(totSum).append("\n");
        }
        System.out.println(sb);
    }

    private static void paint(BC charger) { // 격자에 무선 충전기 표시
        int x = charger.x;
        int y = charger.y;
        int c = charger.c;
        int cnt = 0;
        for (int i = x - c; i <= x + c; i++) {
            for (int j = y - c; j <= y + c; j++) {
                if (inRange(i, j) && Math.abs(x - i) + Math.abs(y - j) <= c) {
                    cnt++;
                    grid[i][j].add(charger);
                }
            }
        }
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < 10 && y >= 0 && y < 10;
    }

    private static void charge() { // 충전
        BC maxA = null;
        BC maxB = null;
        if (grid[Ax][Ay].size() == 0 && grid[Bx][By].size() == 0)
            return; // A,B 위치 모두 충전기가 없을 때
        else if (grid[Ax][Ay].size() == 0 && grid[Bx][By].size() != 0) { // B 위치에만 충전기가 있을 때
            maxB = grid[Bx][By].first();
            totSum += maxB.p;
        } else if (grid[Ax][Ay].size() != 0 && grid[Bx][By].size() == 0) { // A 위치에만 충전기가 있을 때
            maxA = grid[Ax][Ay].first();
            totSum += maxA.p;
        } else { // A, B 위치에 충전기가 있을 때
            int maxSum = Integer.MIN_VALUE;
            for (BC bc1 : grid[Ax][Ay]) {
                for (BC bc2 : grid[Bx][By]) {
                    if (bc1.x == bc2.x && bc1.y == bc2.y)
                        maxSum = Math.max(maxSum, bc1.p);
                    else
                        maxSum = Math.max(maxSum, bc1.p + bc2.p);
                }
            }
            totSum += maxSum;
        }
    }
}
