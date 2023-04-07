package 정리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//중복조합
public class CombiTest2 {
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
        combi(0, 0);
        System.out.println(count);
    }

    private static void combi(int cnt, int start){
        if(cnt == R){
            count++;
            System.out.println(Arrays.toString(nums));
            return;
        }
        for(int i=start; i<N; i++){
            visited[i] = true;
            nums[cnt] = P[i];
            combi(cnt+1, i);
            nums[cnt] = 0;
            visited[i] = false;
        }
    }
}
