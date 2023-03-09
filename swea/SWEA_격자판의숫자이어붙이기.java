import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//dfs
public class SWEA_격자판의숫자이어붙이기 {
    static int T;
    static int[][] grid;
    static Set<Integer> nums;
    static StringBuilder sb;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int tc=1; tc <= T; tc++){
            nums = new HashSet<>(); //중복을 제거하기 위해 set을 사용
            grid = new int[4][4];
            for(int i=0; i<4; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 4; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<4; i++){  //임의의 위치에서 시작하므로 모든 칸에서 dfs를 해본다.
                for(int j=0; j<4; j++){
                    sb = new StringBuilder();
                    sb.append(grid[i][j]);
                    dfs(i, j, 0);
                }
            }

            System.out.printf("#%d %d\n", tc, nums.size());
        }
    }

    static void dfs(int x, int y, int cnt){  //중복을 순회하는 4방 dfs
        if(cnt == 6){  //6번 이동했으면 종료
            nums.add(Integer.parseInt(sb.toString()));  //이동 종료시 set에 넣어준다.
            return;
        }
        for(int i=0; i<4; i++){ //사방 순회
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(inRange(nx,ny)){
                sb.append(grid[nx][ny]);
                dfs(nx, ny, cnt+1);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    static boolean inRange(int x, int y){
        return x >= 0 && x < 4 && y >= 0 && y< 4;
    }
}
