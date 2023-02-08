// import java.io.BufferedReader;
// import java.io.InputStreamReader;
import java.util.Arrays;

public class PermTestAgain {

    static int[] p = {1, 2, 3, 4, 5, 6};
    static int N = p.length;
    static int R;
    static int totCnt;
    static int[] nums;
    static boolean[] visited;

    public static void main(String[] args) {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        R = 3;
        nums = new int[R];
        visited = new boolean[N];

        perm(0);
        System.out.printf("cnt : %d", totCnt);
    }

    public static void perm(int cnt){
        if(cnt == R){
            totCnt++;
            System.out.println(Arrays.toString(nums));
            return;
        }
        for(int i=0; i<N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            nums[cnt] = p[i];
            perm(cnt+1);
            visited[i] = false;
        }
    }
}
