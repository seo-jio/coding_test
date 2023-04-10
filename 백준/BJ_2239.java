import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_2239 {
    static int[][] grid;
    static boolean[][] rowBoolean; // index에 해당하는 숫자가 특정 행에 존재하는지 확인
    static boolean[][] colBoolean;
    static boolean[][] squareBoolean; // 스도쿠를 9등분(0~8)하고 작은 사각형 안에 index에 해당하는 숫자가 존재하는 지 확인
    static List<Point> points;

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int flag = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        points = new ArrayList<>(); // 값이 0인 좌표들을 저장
        grid = new int[9][9];
        rowBoolean = new boolean[9][10];
        colBoolean = new boolean[9][10];
        squareBoolean = new boolean[9][10];
        for (int i = 0; i < 9; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < 9; j++) {
                grid[i][j] = chars[j] - '0';
                if (grid[i][j] == 0) { // 격자의 값이 0인 경우
                    points.add(new Point(i, j));
                } else {
                    int num = grid[i][j];
                    rowBoolean[i][num] = true;
                    colBoolean[j][num] = true;
                    int squareNum = whichSquare(i, j);
                    squareBoolean[squareNum][num] = true;
                }
            }
        }

        dfs(0);
    }

    private static int whichSquare(int x, int y) { // 9등분 했을 때 몇 번째 사각혀에 속하는지를 return
        int r = x / 3;
        int c = y / 3;
        return 3 * r + c;
    }

    private static void dfs(int cnt) {
        if (flag == 1) { // 사전순으로 가장 빠른 게 답이므로 가장 먼저 마주한 완전한 스도쿠 판이 정답이 된다.
            return;
        }
        if (cnt == points.size()) {
            if (flag == 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        sb.append(grid[i][j]);
                    }
                    sb.append("\n");
                }
                System.out.println(sb);
                flag = 1;
            }
            return;
        }
        int x = points.get(cnt).x;
        int y = points.get(cnt).y;
        int squareNum = whichSquare(x, y);
        for (int num = 1; num <= 9; num++) {
            if (isPossible(x, y, num, squareNum)) { // 1~9까지의 숫자 중 가능한 경우만 선택(pruning)
                grid[x][y] = num;
                rowBoolean[x][num] = true;
                colBoolean[y][num] = true;
                squareBoolean[squareNum][num] = true;
                dfs(cnt + 1);
                grid[x][y] = 0;
                rowBoolean[x][num] = false;
                colBoolean[y][num] = false;
                squareBoolean[squareNum][num] = false;
            }
        }
    }

    private static boolean isPossible(int x, int y, int num, int squareNum) {
        // 1. 행 확인
        if (rowBoolean[x][num]) {
            return false;
        }
        // 2. 열 확인
        if (colBoolean[y][num]) {
            return false;
        }
        // 3. 작은 사각형 확인
        if (squareBoolean[squareNum][num]) {
            return false;
        }
        return true;
    }
}
