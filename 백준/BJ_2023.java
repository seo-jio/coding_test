import java.io.*;
import java.util.*;

public class BJ_2023 {
    static int R;
    static int[] nums;
    //소수 성립하기 위해서는 첫번째 자리는 {2, 3, 5, 7}, 그 이후는 {1, 3, 7, 9}가 가능하다.
    static int[] ok = {1, 2, 3, 5, 7, 9};
    static int N = ok.length;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        R = Integer.parseInt(br.readLine());
        nums = new int[R];
        perm2(0, "");
        System.out.println(sb.toString());
    }

    static void perm2(int cnt, String s){
        if(cnt >= 1){
            if(!isPrime(Integer.parseInt(s))) return;
        }
        if(cnt == R){
//            System.out.println(s.indexOf("5"));
            if(nums[0] == 1 || nums[0] == 9) return; //첫번째 자리가 1또는 9일 경우 소수가 아니므로 return
            int z = s.indexOf("5");
            if(z != -1 && z != 0) return;
            System.out.println(s);
            return;
        }
        for(int i=0; i<N; i++){
            nums[cnt] = ok[i];
            perm2(cnt+1, s+ok[i]);
        }
    }

    static boolean isPrime(int n){  //소수 판별하는 함수
        if(n==1) return false;
        for(int i=2; i < (int)(Math.sqrt(n)); i++){
            if(n%i==0) return false;
        }
        return true;
    }
}
