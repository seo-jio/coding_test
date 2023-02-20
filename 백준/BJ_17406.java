import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_17406 {
    static int N;
    static int M;
    static int K;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] grid;
    static int[][] copy; //grid 복사본을 담을 2차원 배열
    static boolean[] visited; //순열을 위해 사용
    static Pair[] nums; //순열을 위해 사용
    static int minNum;
    static Pair[] pairs;
    static class Pair{
        int r;
        int c;
        int s;

        public Pair(int r, int c, int s) { //r, c에 왼쪽 모서리 지점을 담도록 r-s, c-s를 해줌
            this.r = r-s;
            this.c = c-s;
            this.s = s;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "r=" + r +
                    ", c=" + c +
                    ", s=" + s +
                    '}';
        }
    }

    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        grid = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        pairs = new Pair[K];
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            pairs[i] = new Pair(r-1, c-1, s); //격자는 0행 0열 부터 시작하므로 r, c를 1씩 빼줌
        }

        visited = new boolean[K];
        nums= new Pair[K];
        minNum = Integer.MAX_VALUE;
        perm(0);

        System.out.println(minNum);
    }

    private static void rotate(int sx, int sy, int s){ //겹 개수 == s, 왼쪽 위의 모서리 좌표를 인자로 받음
        for(int cnt=0; cnt < s; cnt++){
            int x = sx + cnt;
            int y = sy + cnt;
            int temp = copy[x][y];
            int d = 0;
            while(d<4){ //한 바퀴를 돌리면 무조건 네 방향 모두로 당기기 때문에 이와 같은 종료 조건을 사용
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(nx >= sx+cnt && nx <= sx+2*s-cnt && ny >= sy+cnt && ny <= sy+2*s-cnt){
                    copy[x][y] = copy[nx][ny];
                    x = nx;
                    y = ny;
                }else{  //더 없다면 방향 전환
                    d++;
                }
            }
            copy[x][y+1] = temp;
        }
    }

    private static int cal(){
        int min = Integer.MAX_VALUE;
        for(int i=0; i<N; i++){
            int sum = 0;
            for(int j=0; j<M; j++){
                sum += copy[i][j];
            }
            min = Math.min(min,sum);
        }
        return min;
    }

    private static void perm(int cnt){
        if(cnt == K){ //회전 연산 순서
            //copy 배열 생성
            copy = new int[N][M];
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    copy[i][j] = grid[i][j];
                }
            }
            //회전 연산 개수 만큼 회전
            for(int i=0; i<K; i++){
                rotate(nums[i].r, nums[i].c, nums[i].s);
            }
            minNum = Math.min(minNum, cal());
            return;
        }
        for(int i=0; i<K; i++){
            if(visited[i]) continue;
            visited[i] = true;
            nums[cnt] = pairs[i];
            perm(cnt+1);
            nums[cnt] = null;
            visited[i] = false;
        }
    }
}
