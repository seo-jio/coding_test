import java.io.*;
import java.util.*;

public class BJ_15649 {
    static List<Integer> arr = new ArrayList<>();
    static boolean[] visited;
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        perm(0);
        System.out.println(sb.toString());
    }

    public static void perm(int cnt){  //nPr을 구하는 순열(M == r)
        if(cnt == M){ //nPr
            for(int i=0; i<arr.size(); i++){
                sb.append(arr.get(i)).append(" ");
            }
            sb.append("\n");
        }
        for(int i=1; i<N+1; i++){
            if(visited[i]) continue;
            visited[i] = true;
            arr.add(i);
            perm(cnt +1);
            arr.remove(arr.size()-1);
            visited[i] = false;
        }
    }
}
