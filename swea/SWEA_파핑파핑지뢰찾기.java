import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//0을 먼저 찾아라!!!
public class SWEA_파핑파핑지뢰찾기 {
    static int T;
    static int N;
    static int[][] grid;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static Queue<Pair> queue;
    static boolean[][] visited;
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
        T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            N = Integer.parseInt(br.readLine());
            grid = new int[N+2][N+2]; //주변을 0으로 둘러준다
            for(int i=1; i<=N; i++){
//                String[] temp = br.readLine().split("");
                char[] temp = br.readLine().toCharArray(); //split 사용 시 메모리를 많이 사용하게 된다.
                for(int j=1; j<=N; j++){
//                    if(st.nextToken().equals("*")) grid[i][j] = -1;
                    if(temp[j-1]=='*') grid[i][j] = -1;
                }
            }
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if(grid[i][j] == -1){
                        bomb(i, j);
                    }
                }
            }

            //값이 0인 곳에 8방을 visited true로 변환, 이때 연쇄작용 적용
            int area = 0; //영역의 개수
            visited = new boolean[N+2][N+2];
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if(grid[i][j] == 0 && !visited[i][j]) {
                        queue = new LinkedList<>();
                        queue.offer(new Pair(i, j));
                        visited[i][j] = true;
                        bfs();
                        area++; //영역 개수 증가
                    }
                }
            }

            int solo = 0;  //한 칸짜리
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if(grid[i][j] != -1 && !visited[i][j]){
                        solo++;
                    }
                }
            }
            int ans = area + solo; //최소 클릭 횟수는 영역의 개수 + 한 칸짜리의 개수이다.
            System.out.println("#" + tc + " " + ans);
        }
    }
    private static void bomb(int x ,int y){  //8방에 존재하는 폭탄의 개수를 세어줌
        for(int i=0; i<8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(grid[nx][ny] != -1){ //폭탄이 아닐 경우 숫자 증가
                grid[nx][ny] += 1;
            }
        }
    }
    private static boolean inRange(int x, int y){
        return x >= 1 && x <= N && y >= 1 && y <= N;
    }

    private static void bfs(){
        while(!queue.isEmpty()){
            Pair cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
            for(int i=0; i<8; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    if(inRange(nx, ny) && grid[nx][ny] == 0) queue.offer(new Pair(nx, ny)); //격자 내 존재하고 폭탄이면 queue에 추가(연쇄작용)
                }
            }
        }
    }
}