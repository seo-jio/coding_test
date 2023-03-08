import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_15683 {
    static int N, M;
    static List<Camera> cameras;
    static int min;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static class Camera {
        int x;
        int y;

        public Camera(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Camera{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] grid = new int[N][M];
        cameras = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
                if(grid[i][j] != 0 && grid[i][j] != 6){
                    cameras.add(new Camera(i, j));
                }
            }
        }
        min = Integer.MAX_VALUE;
        dfs(0, grid);
        System.out.println(min);
    }

    private static void dfs(int cnt, int[][] grid2){
        if(cnt == cameras.size()){
            int temp = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(grid2[i][j] == 0) temp++;
                }
            }
            min = Math.min(min, temp);

            return;
        }
        Camera c = cameras.get(cnt);
        int x = c.x;
        int y = c.y;
        List<Integer> dirs;
        int d1, d2, d3;
        switch(grid2[x][y]){
            case 1:  //1번 화살표
                for(int i=0; i<4; i++){
                    dirs = new ArrayList<>();
                    dirs.add(i);
                    int[][] copy = new int[N][M];
                    gridToCopy(grid2, copy);  //복사본 생성
                    paint(x, y, dirs, copy);  //복사본을 dfs의 매개변수로 넘겨주면서 색칠해 나간다.
                    dfs(cnt+1, copy);
                }
                break;
            case 2:  //2번 화살표
                for(int i=0; i<2; i++){
                    dirs = new ArrayList<>();
                    dirs.add(i);
                    dirs.add(i+2);
                    int[][] copy = new int[N][M];
                    gridToCopy(grid2, copy);
                    paint(x, y, dirs, copy);
                    dfs(cnt+1, copy);
                }
                break;
            case 3:   //3번 화살표
                d1 = 0;
                d2 = 1;
                for(int i=0; i<4; i++){
                    dirs = new ArrayList<>();
                    dirs.add((d1+i)%4);
                    dirs.add((d2+i)%4);
                    int[][] copy = new int[N][M];
                    gridToCopy(grid2, copy);
                    paint(x, y, dirs, copy);
                    dfs(cnt+1, copy);
                }
                break;
            case 4:  //4번 화살표
                d1 = 3;
                d2 = 0;
                d3 = 1;
                for(int i=0; i<4; i++){
                    dirs = new ArrayList<>();
                    dirs.add((d1+i)%4);
                    dirs.add((d2+i)%4);
                    dirs.add((d3+i)%4);
                    int[][] copy = new int[N][M];
                    gridToCopy(grid2, copy);
                    paint(x, y, dirs, copy);
                    dfs(cnt+1, copy);
                }
                break;
            case 5:  //5번 화살표
                dirs = new ArrayList<>();
                dirs.add(0);
                dirs.add(1);
                dirs.add(2);
                dirs.add(3);
                int[][] copy = new int[N][M];
                gridToCopy(grid2, copy);
                paint(x, y, dirs, copy);
                dfs(cnt+1, copy);
                break;
        }
    }

    private static void paint(int x, int y, List<Integer> dirs, int[][] copy){ //감시되는 구역을 -1로 바꿔줌
//        System.out.println(dirs.toString());
        for(int d : dirs){
            // d가 바뀔 때마다 시작 점을 다시 초기화 해줘야 된다!!!
            int sx = x;
            int sy = y;
            while(true){
                int nx = sx + dx[d];
                int ny = sy + dy[d];
                if(!inRange(nx, ny)) break; //범위 안에 드는지
                if(copy[nx][ny] == 6) break; //벽이 아닌지
                if(copy[nx][ny] == 0) copy[nx][ny] = -1; //0이면 -1로 변경, 카메라는 바꾸지 않기 위해
                sx = nx;
                sy = ny;
            }
        }
    }

    private static boolean inRange(int x, int y){
        return x >= 0 && x < N && y >= 0 && y <M;
    }
    private static void gridToCopy(int[][] grid2, int[][] copy){ //copy에 grid를 복사한다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy[i][j] = grid2[i][j];
            }
        }
    }
}
