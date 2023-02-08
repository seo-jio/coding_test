import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 코드트리에서 기반한 backtracking을 활용한 조합 코드
public class Combination {
    static List<Integer> arr = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static int[] nums;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        for(int i=0; i<N; i++){
            nums[i] = i+1;
        }
        comb(1, 0);
        System.out.print(sb.toString());
    }

    public static void comb(int cur, int cnt){ //현재 선택하는 숫자, 여태 껏 선택한 숫자의 개수
        if(cur == N+1) {
            if(cnt == M){
                for(int i=0; i<arr.size(); i++){
                    sb.append(arr.get(i)).append(" ");
                }
                sb.append("\n");
            }
        }else{
            arr.add(cur);
            comb(cur+1, cnt+1);
            arr.remove(arr.size()-1);

            comb(cur+1, cnt);

            //숫자들을 선택할지 말지, 원래 이 코드가 위에 코드로 변경된 거다!
//            arr.add(1);
//            comb(cur+1, cnt+1);
//            arr.remove(arr.size()-1);
//
//            arr.add(0);
//            comb(cur+1, cnt);
//            arr.remove(arr.size()-1);
        }
    }
}
