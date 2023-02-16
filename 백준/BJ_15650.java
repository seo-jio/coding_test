import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_15650 {
    static List<Integer> arr = new ArrayList<>();
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        comb(1, 0);
        System.out.println(sb.toString());
    }

    public static void comb(int cur, int cnt){
        if(cur == N+1){
            if(cnt == M){
                for(int i=0; i<arr.size(); i++){
                    sb.append(arr.get(i)).append(" ");
                }
                sb.append("\n");
            }
            return;
        }
        arr.add(cur);
        comb(cur+1, cnt +1);
        arr.remove(arr.size() -1);

        comb(cur+1, cnt);
    }
}
