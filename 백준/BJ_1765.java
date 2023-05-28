import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1765 {
    static int N, M;
    static int[] P;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        makeSet();
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if(P[s] != P[e]){
                union(s, e);
            }
        }

        for (int i = 1; i < N+1; i++) {
            find(i);
        }

        System.out.println(Arrays.toString(P));
    }

    private static void makeSet(){
        P = new int[N+1];
        for (int i = 0; i < N+1; i++) {
            P[i] = i;
        }
    }

    private static int find(int x){
        if(P[x] == x) return x;
        else return P[x] = find(P[x]);
    }

    private static void union(int x, int y){
        int px = find(x);
        int py = find(y);
        P[py] = px;
    }
}
