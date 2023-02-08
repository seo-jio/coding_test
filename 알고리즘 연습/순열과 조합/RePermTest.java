import java.util.Arrays;

// 중복순열
public class RePermTest {

    static int[] p = {1, 2, 3, 4, 5, 6};
    static int N = p.length;
    static int R;
    static int totCnt;
    static int[] nums;

    public static void main(String[] args) {
        R = 3;
        nums = new int[R];

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
            nums[cnt] = p[i];
            perm(cnt+1);
        }
    }
}
