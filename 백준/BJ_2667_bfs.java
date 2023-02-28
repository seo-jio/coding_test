import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//flood fill
public class BJ_2667_bfs {
    static int N;
    static int[][] grid;
    static boolean[][] visited;
    static Queue<Pair> pairs;
    static List<Integer> ans = new ArrayList<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int cnt;
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
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        grid = new int[N][N];
        for(int i=0; i<N; i++){
            char[] chars = br.readLine().toCharArray();
            for(int j=0; j<N; j++){
                grid[i][j] = chars[j] - '0'; //int로 변환
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(canGo(i, j)){
                    visited[i][j] = true;
                    cnt = 1;
                    pairs = new LinkedList<>();
                    pairs.offer(new Pair(i, j));
                    bfs();
                    ans.add(cnt);
                }

            }
        }
        Collections.sort(ans);
        System.out.println(ans.size());
        for(Integer i : ans){
            System.out.println(i);
        }
    }

    public static void bfs(){
        while(!pairs.isEmpty()){
            Pair cur = pairs.poll();
            int x = cur.x;
            int y = cur.y;
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(canGo(nx, ny)){
                    cnt++;
                    visited[nx][ny] = true;
                    pairs.offer(new Pair(nx, ny));
                }
            }
        }
    }

    public static boolean inRange(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static boolean canGo(int x, int y){
        if(inRange(x, y) && grid[x][y] == 1 && !visited[x][y]){
            return true;
        }
        return false;
    }
}
