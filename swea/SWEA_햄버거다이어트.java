import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_햄버거다이어트 {
    static int T;
    static int N,L;
    static int[] tastes;
    static int[] calories;
    static boolean[] visited;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            tastes = new int[N];
            calories = new int[N];
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                tastes[i] = Integer.parseInt(st.nextToken());
                calories[i] = Integer.parseInt(st.nextToken());
            }
            visited = new boolean[N];
            max = -Integer.MAX_VALUE;
            subSet(0, 0, 0);
            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }
        System.out.print(sb);
    }

    private static void subSet(int cnt, int tSum, int cSum){
        if(cnt == N){
            if(cSum <= L){ //제한 칼로리를 넘지 않는 지 확인
                max = Math.max(max, tSum);
            }
            return;
        }
        visited[cnt] = true;
        subSet(cnt+1, tSum+tastes[cnt], cSum+calories[cnt]);
        visited[cnt] = false;
        subSet(cnt+1, tSum, cSum);
    }
}
