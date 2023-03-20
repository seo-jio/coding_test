import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_3055 {
    static int N, M;
    static char[][] grid;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int flag = 0;
    static Queue<Pair> hedges;
    static Queue<Pair> waters;
    static class Pair{
        int x;
        int y;

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
        int cnt = 0;
        while(!isEnd()){
            cnt++;
            hedges = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(grid[i][j] == 'S'){
                        hedges.offer(new Pair(i, j));
                    }
                }
            }
            bfsHedge();

            waters = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(grid[i][j] == '*'){
                        waters.offer(new Pair(i, j));
                    }
                }
            }
            bfsWater();
        }

        if(flag == 1){
            System.out.println(cnt);
        }else{
            System.out.println("KAKTUS");
        }
    }

    private static void bfsHedge() {
        while (!hedges.isEmpty()){
            Pair cur = hedges.poll();
            int x = cur.x;
            int y = cur.y;
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(inRange(nx, ny) && (grid[nx][ny] =='.' || grid[nx][ny] == 'D')){
                    if(grid[nx][ny] == 'D'){
                        flag = 1;
                    }
                    grid[nx][ny] = 'S';
                }
            }
        }
    }

    private static void bfsWater() {
        while (!waters.isEmpty()){
            Pair cur = waters.poll();
            int x = cur.x;
            int y = cur.y;
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(inRange(nx, ny) && (grid[nx][ny]=='.' || grid[nx][ny] == 'S')){
                    grid[nx][ny] = '*';
                }
            }
        }
    }

    private static boolean inRange(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    private static boolean isEnd(){
        if(flag == 1) return true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(grid[i][j] == 'D'){
                    for(int d=0; d<4; d++){
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if(!inRange(nx, ny)) continue;
                        if(grid[nx][ny] == 'S' || grid[nx][ny] == '.'){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
