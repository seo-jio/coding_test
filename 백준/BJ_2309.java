import java.io.*;
import java.util.*;

public class BJ_2309 {
    static int[] heights = new int[9];
    static int[] nums;
    static int N = 9;
    static int R = 7;
    static int flag = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nums = new int[R];
        for(int i=0; i<9; i++){
            heights[i] = Integer.parseInt(br.readLine());
        }
        combi(0, 0, 0);
    }

    public static void combi(int cnt, int start, int sum){
        if(flag == 0) return;
        if(cnt == R){
            if(sum == 100){
                flag = 0;
                List<Integer> tmp = new ArrayList<>();
                for(int n : nums){
                    tmp.add(heights[n]);
                }
                Collections.sort(tmp);
                for(int t : tmp){
                    System.out.println(t);
                }
            }
            return;
        }
        for(int i=start; i<N; i++){
            nums[cnt] = i;
            combi(cnt+1, i+1, sum+heights[i]);
        }
    }
}
