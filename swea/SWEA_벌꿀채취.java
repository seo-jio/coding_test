import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_벌꿀채취 {
    static int T, N, M, C;
    static int[][] grid;
    static int max, ans;
    static List<Pair> cases; //연속된 M개를 선택한 경우들을 저장할 변수
    static class Pair{
        int row;
        int s; //시작 위치
        int e; //끝 위치
        int honey; //채취한 꿀

        public Pair(int row, int s, int e, int honey) {
            this.row = row;
            this.s = s;
            this.e = e;
            this.honey = honey;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            grid = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            cases = new ArrayList<>();
            findCase(); //가능한 case 찾기

            ans = 0;
            for (int i = 0; i < cases.size(); i++) {
                for (int j = i+1; j < cases.size(); j++) {
                    if(isPossible(i, j)){
                        Pair a = cases.get(i);
                        Pair b = cases.get(j);
                        ans = Math.max(ans, a.honey + b.honey);
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean isPossible(int i, int j) { //겹치는지 확인
        Pair a = cases.get(i);
        Pair b = cases.get(j);
        if(a.row == b.row){
            if(a.e >= b.s || a.s <= b.e) return false;
        }
        return true;
    }

    private static void findCase() { //연속된 M개의 칸에서 꿀을 채취하는 경우들을 찾음
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(j+M-1 >= N) break; //격자에서 벗어날 경우
                int honey = cal(i, j, j+M-1);
                cases.add(new Pair(i, j, j+M-1, honey));
            }
        }
    }

    private static int cal(int row, int s, int e){ //s : 시작 위치, e : 종료 위치
        boolean[] visited = new boolean[M];
        int[] nums = Arrays.copyOfRange(grid[row], s, e+1);
        max = 0;
        subSet(0, visited, nums, 0, 0);
        return max;
    }
    private static void subSet(int cnt, boolean[] visited, int[] nums, int sum, int total){
        if(sum > C) return; //합이 C를 넘는 경우
        if(cnt == M){
            max = Math.max(max, total);
            return;
        }
        visited[cnt] = true;
        subSet(cnt+1, visited, nums, sum+nums[cnt], total+ nums[cnt]*nums[cnt]);
        visited[cnt] = false;
        subSet(cnt+1, visited, nums, sum, total);
    }
}