package 정리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//중복 순열
public class PermTest2 {
    static int[] P = {1, 2, 3, 4, 5};
    static int N = P.length;
    static int R;
    static int count;
    static int[] nums;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        R = 3;
        count = 0;
        nums = new int[R];
        perm(0);
        System.out.println(count);
    }

    private static void perm(int cnt){
        if(cnt == R){
            count++;
            System.out.println(Arrays.toString(nums));
            return;
        }
        for(int i=0; i<N; i++){
            nums[cnt] = P[i];
            perm(cnt+1);
            nums[cnt] = 0;
        }
    }
}
