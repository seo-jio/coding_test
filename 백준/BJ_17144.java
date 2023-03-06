import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_17144 {
    static int R, C, T;
    static int[][] grid;
    static int[] dx1 = {-1, 0, 1, 0}; //1번 공기 청정기
    static int[] dy1 = {0, 1, 0, -1};
    static int[] dx2 = {1, 0, -1, 0}; //2번 공기 청정기
    static int[] dy2 = {0, 1, 0, -1};
    static int X1, Y1, X2, Y2; //공기 청정기 위치 저장
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        grid = new int[R][C];
        int first = 0; //첫 번째 공기청정기인지 확인
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if(grid[i][j] == -1 && first == 0){ //1번 공기청정기
                    X1 = i;
                    Y1 = j;
                    first = 1;
                } else if (grid[i][j] == -1 && first != 0) { //2번 공기청정기
                    X2 = i;
                    Y2 = j;
                }
            }
        }

        for (int i = 0; i < T; i++) {
            spread();
            simulation(X1, Y1, dx1, dy1, 1);
            simulation(X2, Y2, dx2, dy2, 2);
        }

        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sum += grid[i][j];
            }
        }
        System.out.println(sum+2); //공기 청정기가 -1이므로 +2 해준다.
    }

    private static void simulation(int sx, int sy, int[] dx, int[] dy, int order) {
        int d = 0;
        int x = sx + dx[d]; //x,y(현재 보는 지점)를 지정한 방향으로 한 칸 보내놓는다.(공기청정기에 값이 덮어지면 안되기 때문에)
        int y = sy + dy[d];
        while(d < 4){
             int nx = x + dx[d];
             int ny = y + dy[d];
             if(order == 1){ //첫 번째 공기 청정기인 경우
                 if(nx < 0 || nx > sx || ny < 0 || ny >= C){
                     d++;
                     continue;
                 }
             }
             else{  //두 번째 공기 청정기인 경우
                 if(nx < sx || nx >= R || ny < 0 || ny >= C){
                     d++;
                     continue;
                 }
             }
            if(grid[nx][ny] == -1){ //새로운 좌표가 공기 청정기일 경우 break
                grid[x][y] = 0;
                break;
            }
             else{ //아닌 경우 땡겨줌
                 grid[x][y] = grid[nx][ny];
             }
             x = nx; //x,y 좌표 이동
             y = ny;
        }
    }


    private static void spread() {
        //1. 복사본 생성
        int[][] copy = new int[R][C];
        for (int i = 0; i < R; i++) {
            copy[i] = Arrays.copyOf(grid[i], C);
        }
        //2. 확산
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(grid[i][j]/5 > 0){ //먼지이면서 5로 나눈 값이 0보다 큰 경우
                    int cnt = 0;
                    for(int d=0; d<4; d++){
                        int nx = i + dx1[d];
                        int ny = j + dy1[d];
                        if(!inRange(nx, ny)) continue;
                        if(grid[nx][ny] == -1) continue;
                        copy[nx][ny] += grid[i][j] / 5; //먼지 확산
                        cnt ++;
                    }
                    copy[i][j] -= grid[i][j]/5*cnt; //먼지 값 감소
                }
            }
        }
        //3. 원본 배열에 결과 반영
        for (int i = 0; i < R; i++) {
            grid[i] = Arrays.copyOf(copy[i], C);
        }
    }
    private static boolean inRange(int x, int y){
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}