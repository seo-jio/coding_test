import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10971 {

    static int[][] cost;
    static int K;
    static int N;
    static int[] nums;
    static boolean[] visited;
    static int minCost = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        N = K;
        nums = new int[N+1];    //마지막에 첫 번째로 선택한 수를 추가해주기 위해 size를 N+1로 설정
        visited = new boolean[N];
        cost = new int[K][K];
        for(int i=0; i<K; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<K; j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        perm(0);
        System.out.println(minCost);
    }

    static void perm(int cnt) {
        if(cnt==N) {
            minCost = Math.min(minCost, cal(nums));
            return ;
        }
        //선택한 수들 중 겹치는 게 없도록 방문 배열을 사용한다.
        //2 1 3과 1 2 3이 다르기 때문에 for문이 매번 0부터 주어진 범위(N)까지 돌게 된다.
        for (int i = 0; i < N; i++) {
            if(visited[i]) continue;
            visited[i]=true;
            nums[cnt]=i;
            perm(cnt+1);
            visited[i]=false;
        }
    }

    static int cal(int[] nums){
        nums[N] = nums[0]; //마지막에 첫 번째로 선택한 수를 추가
        int tmpSum = 0;
        for(int i=0; i<N; i++){ // nums.length - 1까지만 for문을 돌림
            int start = nums[i];
            int end = nums[i+1];
            if(cost[start][end] == 0){ //길이 없는 경우 고려해줌
                return 1000001;
            }
            tmpSum += cost[start][end];
        }
        return tmpSum;
    }
}
