import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_프로세서 {
    static int T, N;
    static int[][] grid;
    static List<Pair> cores;
    static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int maxCnt;
    static int minDis;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=T; tc++){
            N = Integer.parseInt(br.readLine());
            grid = new int[N][N]; //grid를 subset의 매개변수로 넣기 위해 지역변수로 선언
            cores = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                    if(i==0 || j== 0 || i == N-1 || j == N-1) continue; //격자 둘레에 있는 경우
                    if(grid[i][j] == 1) cores.add(new Pair(i ,j));    //둘레 안에 있는 프로세스인 경우에만 추가
                }
            }
            maxCnt = Integer.MIN_VALUE;
            minDis = Integer.MAX_VALUE;
            subSet(0, 0, 0);
            sb.append("#").append(tc).append(" ").append(minDis).append("\n");
        }
        System.out.println(sb);
    }

    private static void subSet(int cur, int cnt, int length){
        if(cnt + cores.size() - cur < maxCnt) return; //남은 코어의 개수 + 현재 선택한 코어의 개수가 최대 코어수보다 작다면 return
        if(cur == cores.size()){
            if(cnt > maxCnt){ //코어 수가 같은 경우 최소 전선 길이 갱신
                maxCnt = Math.max(maxCnt, cnt);
                minDis = length;
            }
            else if(cnt == maxCnt){ //코어수가 더 많으면 무조건 전선 길이 갱신
                minDis = Math.min(minDis, length);
            }
            return;
        }
        for(int d=0; d<4; d++){ //4방 탐색
            int canPaint = paint(cur, d); //전선을 이을 수 있는지 없는지 확인후 가능하다면 전선을 이어줌
            if(canPaint > 0){
                subSet(cur+1, cnt+1, length+canPaint);
                erase(cur, d); //이은 전선을 지워 준다.
            }
        }
        subSet(cur+1, cnt, length);
    }

    private static void erase(int curNum, int d){ //이어놨던 전선을 다시 지워주는 메소드
        Pair cur = cores.get(curNum);
        int x = cur.x;
        int y = cur.y;
        while(true){
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(!inRange(nx, ny)) break;
            grid[nx][ny] = 0;
            x = nx;
            y = ny;
        }
    }

    private static int paint(int curNum, int d){ //전선을 이어주는 메소드, cnt : 몇 번째 맥시노스인지, d : 전선을 이을 방향
        Pair cur = cores.get(curNum);
        int x = cur.x;
        int y = cur.y;

        //1. 전선을 이을 수 있는 지 먼저 확인
        int flag = 1;
        while(true){
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(!inRange(nx, ny)) break;
            if(grid[nx][ny] != 0){ //멕시노스나 다른 전선에 가로막히는 경우
                flag = 0;
                break;
            }
            x = nx;
            y = ny;
        }
        if(flag == 0) return -1;

        //2. 격자판 갱신(전선 : 2)
        x = cur.x;
        y = cur.y;
        int length = 0;
        while(true){
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(!inRange(nx, ny)) break;
            grid[nx][ny] = 2;
            length += 1;
            x = nx;
            y = ny;
        }
        return length;
    }

    private static boolean inRange(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}