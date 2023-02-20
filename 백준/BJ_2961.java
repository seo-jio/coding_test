import java.io.*;
import java.util.*;

public class BJ_2961 {
    static int N;
    static int R;
    static int[] nums;
    static Long ans = Long.MAX_VALUE;
    static List<List<Integer>> tastes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        tastes = new ArrayList<>();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sour = Integer.parseInt(st.nextToken());
            int bitter = Integer.parseInt(st.nextToken());
            List<Integer> temp = new ArrayList<>();
            temp.add(sour);
            temp.add(bitter);
            tastes.add(temp);
        }
//        System.out.println(tastes.size());
        power(0, 0, 1);
        System.out.println(ans);

    }

    static void power(int cnt, int tot, int mul) {
        if(cnt==N) {
            if(tot != 0){
                ans = Math.min(ans, Math.abs(tot - mul));
            }
            return ;
        }
        power(cnt+1,tot+tastes.get(cnt).get(1), mul*tastes.get(cnt).get(0)); //선택 했을 경우
        power(cnt+1,tot, mul);                        //선택하지 않았을 경우
    }
}
