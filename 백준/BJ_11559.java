import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_11559 {
    static String[][] grid;
    static String[][] copy;
    static String[][] nextGrid;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int round;
    static int N = 12;
    static int M = 6;
    static Queue<Pair> queue;
    static boolean[][] visited;
    static String type;
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
        grid = new String[N][M];
        for(int i=0; i<N; i++){
            String[] temp = br.readLine().split("");
            for(int j=0; j<M; j++){
                grid[i][j] = temp[j];
            }
        }

        round = 0;
        while(puyoExist()){
            round++;
        }
        System.out.println(round);
    }

    private static boolean puyoExist(){
        //터지는 뿌요가 여러 개일 수도 있으므로 뿌요가 터지는 경우 grid에 바로 옮기지 않고 nextGrid에 옮긴다.
        nextGrid = new String[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                nextGrid[i][j] = ".";
            }
        }
        int flag = 0; //터지는 뿌요가 있는 지 확인
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!grid[i][j].equals(".")){
                    cnt = 1;
                    type = grid[i][j];  //현재 뿌요 타입 지정
                    visited = new boolean[N][M];
                    visited[i][j] = true;
                    queue = new LinkedList<>();
                    queue.offer(new Pair(i, j));
                    bfs();
                    if(cnt >= 4){
                        bomb();
                        flag = 1;
                    }
                }
            }
        }
        sync();
        return flag == 1;
    }

    private static void sync(){ //Grid에 nextGrid를 옮겨줌
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                grid[i][j] = nextGrid[i][j];
            }
        }
    }

    private static void bomb(){ //뿌요 터뜨리기
        for(int i=0; i<N; i++){ //뿌요가 터질 위치는 "."으로 변경
            for(int j=0; j<M; j++){
                if(visited[i][j]){
                    grid[i][j] = ".";
                }
            }
        }
        //copy 초기화
        copy = new String[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                copy[i][j] = ".";
            }
        }
        //뿌요가 터진 이후의 결과를 copy에 저장
        for(int j=0; j<M; j++){
            int rowNum = N-1;
            for(int i=N-1; i>=0; i--){
                if(!grid[i][j].equals(".")){
                    copy[rowNum--][j] = grid[i][j];
                }
            }
        }
        //nextGrid에 copy를 옮겨줌
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                nextGrid[i][j] = copy[i][j];
            }
        }
    }

    private static void bfs(){
        while(!queue.isEmpty()){
            Pair cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(canGo(nx, ny)){
                    visited[nx][ny] = true;
                    queue.offer(new Pair(nx, ny));
                    cnt++;
                }
            }
        }
    }

    private static boolean inRange(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    private static boolean canGo(int x, int y){
        if(inRange(x, y) && !visited[x][y] && grid[x][y].equals(type)){
            return true;
        }
        return false;
    }
}