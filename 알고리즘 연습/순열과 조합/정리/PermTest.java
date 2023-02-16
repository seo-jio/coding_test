package 정리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//순열
public class PermTest {
    static int[] P = {1, 2, 3, 4, 5};
    static int N = P.length;
    static int R;
    static int count;
    static int[] nums;
    static boolean[] visited; //depth를 찾을 때는 int로 하는 경우도 있다.

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        R = 3;
        count = 0;
        nums = new int[R];
        visited = new boolean[N];
        perm(0);
        System.out.println(count);
    }

    //if문에 결과를 골라낼 뿐 실행 자체는 N^R 반복하지만
    private static void perm(int cnt){
        if(cnt == R){
            count++;
            System.out.println(Arrays.toString(nums));
            return;
        }
        for(int i=0; i<N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            nums[cnt] = P[i];
            perm(cnt+1);
            nums[cnt] = 0;
            visited[i] = false;
        }
    }
}
