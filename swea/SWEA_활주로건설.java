import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_활주로건설 {
    static int T, N, X;
    static int[][] grid;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            if(isPossibleRow(i)){
                ans++;
            }
            if(isPossibleCol(i)){
                ans++;
            }
        }
        System.out.println(ans);
    }

    private static boolean isPossibleRow(int row){
        boolean[] visited = new boolean[N];
        int curIdx = 1;
        while(curIdx < N){
            int left = grid[row][curIdx - 1]; //이전 값
            int cur = grid[row][curIdx];      //현재 값
            if(Math.abs(cur - left) > 1){     //높이 차이가 1이상인 경우
                return false;
            }
            if(left < cur){ //왼쪽으로 경사로 설치
                for (int i = 1; i <= X; i++) {
                    if(curIdx-i < 0){ //경사로가 격자를 벗어나는 경우
                        return false;
                    }
                    if(grid[row][curIdx-i] != left || visited[curIdx - i]){
                        return false;
                    }
                    visited[curIdx - i] = true;
                }
            }else if(left > cur){ //오른쪽으로 경사로 설치
                for (int i = 1; i <= X; i++) {
                    if(curIdx-1+i >= N){ //경사로가 격자를 벗어나는 경우
                        return false;
                    }
                    if(grid[row][curIdx-1+i] != cur || visited[curIdx - 1 + i]){ //경사로 내 숫자 값이 동일하지 않은 경우
                        return false;
                    }
                    visited[curIdx - 1 + i] = true;
                }
            }
            curIdx++;
        }
        return true;
    }

    private static boolean isPossibleCol(int col){
        boolean[] visited = new boolean[N];
        int curIdx = 1;
        while(curIdx < N){
            int down = grid[curIdx-1][col]; //이전 값
            int cur = grid[curIdx][col];    //현재 값
            if(Math.abs(cur - down) > 1){ //높이 차이가 1이상인 경우
                return false;
            }
            if(down < cur){ //위쪽으로 경사로 설치
                for (int i = 1; i <= X; i++) {
                    if(curIdx-i < 0){ //경사로가 격자를 벗어나는 경우
                        return false;
                    }
                    if (grid[curIdx - i][col] != down || visited[curIdx - i]) {
                        return false;
                    }
                    visited[curIdx - i] = true;
                }
            }else if(down > cur){ //아래쪽으로 경사로 설치
                for (int i = 1; i <= X; i++) {
                    if(curIdx-1+i >= N){ //경사로가 격자를 벗어나는 경우
                        return false;
                    }
                    if (grid[curIdx - 1 + i][col] != cur || visited[curIdx - 1 + i]) { //경사로 내 숫자 값이 동일하지 않은 경우
                        return false;
                    }
                    visited[curIdx - 1 + i] = true;
                }
            }
            curIdx++;
        }
        return true;
    }
}
