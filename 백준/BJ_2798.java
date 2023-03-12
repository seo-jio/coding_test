import java.io.*;
import java.util.*;

public class BJ_2798 {
    static int[] cards;
    static int[] nums;
    static int N;
    static int M;
    static int[] ans = new int[]{Integer.MAX_VALUE, 0}; //첫 번째 인덱스에는 차이의 최솟값, 두 번째 인덱스에는 그 경우의 합을 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[3];
        cards = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }

        combi(0, 0, 0);
        System.out.println(ans[1]);
    }

    public static void combi(int cnt, int start, int sum){
        if(cnt == 3){
            int diff = M - sum; //M과 sum의 차이
            if(diff >= 0 && diff < ans[0]){ //차이가 0이상이고 차이의 최솟값보다 현재 차이가 더 작다면 차이와 합을 갱신
                ans[0] = diff;
                ans[1] = sum;
            }
            return;
        }
        for(int i=start; i<N; i++){
            nums[cnt] = cards[i];
            combi(cnt+1, i+1, sum+cards[i]);
        }
    }
}