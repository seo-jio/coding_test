import java.util.*;
import java.io.*;

// ArrayList 사용한 순열 코드
public class Permutation {

    static boolean[] visited;
    static List<Integer> arr = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        perm(1);
        System.out.println(sb);
    }

    public static void perm(int cnt){ //nPn을 구하는 순열
        if(cnt == N+1){
            for(int i = 0; i<arr.size(); i++){
                sb.append(arr.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1; i<N+1; i++){
            if(visited[i]) continue;
            visited[i] = true;
            arr.add(i);

            perm(cnt+1);

            arr.remove(arr.size()-1);
            visited[i] = false;
        }
    }
}
