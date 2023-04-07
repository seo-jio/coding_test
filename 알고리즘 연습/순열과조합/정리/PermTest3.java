package 정리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//Bit Masking을 활용한 순열
public class PermTest3 {
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
        perm(0, 0);
        System.out.println(count);
    }

    //if문에 결과를 골라낼 뿐 실행 자체는 N^R 반복하지만
    private static void perm(int cnt, int flag){
        if(cnt == R){
            count++;
            System.out.println(Arrays.toString(nums));
            return;
        }
        for(int i=0; i<N; i++){
            if((flag & (1<<i)) != 0) continue;
            nums[cnt] = P[i];
            perm(cnt+1, (flag | (1<<i)));
            nums[cnt] = 0;
        }
    }
}
