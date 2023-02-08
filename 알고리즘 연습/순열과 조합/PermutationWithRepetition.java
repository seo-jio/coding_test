import java.io.*;
import java.util.*;

//코드트리에 기반한 중복순열, 기존 순열 코드에서 visited를 제거한 모습
public class PermutationWithRepetition {
    static List<Integer> arr = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        choose(0);
        System.out.println(sb.toString());
    }

    public static void choose(int n){
        if(n == N){
            for(int i=0; i<arr.size(); i++){ //StringBuilder 사용을 습관화 하자!!
                sb.append(arr.get(i)).append(" ");
            }
            sb.append("\n");
        }else{
            for(int i=1; i< K+1; i++){
                if(n >= 2 && arr.get(arr.size()-1) == i && arr.get(arr.size()-2) == i){
                    continue;
                }
                arr.add(i);
                choose(n+1);
                arr.remove(arr.size()-1);
            }
        }

    }
}
