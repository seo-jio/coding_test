import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_벽돌깨기 {
    static int T, N, W, H;
    static int min;

    static Queue<Pair> que;
    static class Pair{
        int x;
        int y;
        int dis; //방문처리를 하기 위해

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
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            int[][] grid = new int[H][W];
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            min = Integer.MAX_VALUE;
            perm(0, grid);
            sb.append("#").append(tc).append(" ").append(min).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean perm(int cnt, int[][] grid){ //중복 순열로 구슬을 떨어뜨릴 위치 결정
        int remain = getRemain(grid);
        if(remain == 0){ //남아있는 벽돌이 없을 경우
            min = 0;
            return true;
        }
        if(cnt == N){ //모든 구슬을 선택한 경우
            min = Math.min(min, remain);
            return false;
        }

        for (int col = 0; col < W; col++) { //구슬과 충돌하는 벽돌 위치 찾기
            int row = -1;
            for (int j = 0; j <H; j++) {
                if(grid[j][col] != 0){
                    row = j;
                    break;
                }
            }
            if(row == -1) continue; //구슬을 떨어뜨린 열에 벽돌이 없을 경우

            int[][] copy = new int[H][W]; //복사본 생성
            copy(grid, copy);

            que = new ArrayDeque<>(); //bfs시작
            if(grid[row][col] > 1){
                que.offer(new Pair(row, col, grid[row][col]));
            }
            copy[row][col] = 0;
            bomb(copy);

            gravity(copy); //중력 작용

            perm(cnt+1, copy); //다음 구슬 떨어뜨림
        }
        return false;
    }

    private static void copy(int[][] grid, int[][] copy){
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                copy[i][j] = grid[i][j];
            }
        }
    }
    private static int getRemain(int[][] grid){
        int cnt = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if(grid[i][j] != 0) cnt++;
            }
        }
        return cnt;
    }

    private static void gravity(int[][] grid) { //중력 작용
        for(int j=0; j<W; j++){
            int[] temp = new int[H];
            int idx = H-1;
            for (int i = H-1; i >= 0; i--) {
                if(grid[i][j] != 0){
                    temp[idx] = grid[i][j];
                    idx--;
                }
            }

            for (int i = H-1; i >= 0; i--) {
                grid[i][j] = temp[i];
            }
        }
    }

    private static void bomb(int[][] grid) { //폭발한 벽돌 개수 return
        while(!que.isEmpty()){
            Pair cur = que.poll();
            int x = cur.x;
            int y = cur.y;
            int dis = cur.dis-1;
            grid[x][y] = 0;
            for(int d=0; d<4; d++){
                for (int i = 1; i <= dis; i++) { //한쪽 방향으로 dis만큼 탐색 후 방향 전환
                    int nx = x + dx[d] * i;
                    int ny = y + dy[d] * i;
                    if(inRange(nx, ny) && grid[nx][ny] != 0){
                        if(grid[nx][ny] > 1){ //1보다 큰 경우에만 que에 넣어줌, 1일경우에는 바로 터뜨려준다.
                            que.offer(new Pair(nx, ny, grid[nx][ny]));
                        }
                        grid[nx][ny] = 0;
                    }
                }
            }
        }
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < H && y >= 0 && y < W;
    }
}

