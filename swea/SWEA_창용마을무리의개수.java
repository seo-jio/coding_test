import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_창용마을무리의개수 {
    static int T, N, M;
    static int[] P;
    static Queue<Edge> que;
    static class Edge{
        int s;
        int e;

        public Edge(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            que = new ArrayDeque<>();
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                que.offer(new Edge(s, e));
            }
            makeSet();
            while (!que.isEmpty()) {
                Edge cur = que.poll();
                int ps = find(cur.s);
                int pe = find(cur.e);
                if(ps == pe) continue;
                union(ps, pe);
            }

            for (int i = 1; i <= N; i++) { //P값을 최상위 부모노드로 갱신
                find(i);
            }
            Set<Integer> set = new HashSet<>(); //set에 최상위 부모 추가
            for (int i = 1; i <= N; i++) {
                set.add(P[i]);
            }
            sb.append("#").append(tc).append(" ").append(set.size()).append("\n");
        }
        System.out.println(sb);
    }

    private static void makeSet(){
        P = new int[N+1]; //1번 부터 시작하기 위해 +1
        for(int i=0; i<=N; i++){
            P[i] = i;
        }
    }

    private static int find(int x){
        if(P[x] == x) return x;
        else return P[x] = find(P[x]); //P[x] 값을 계속해서 상위 부모로 갱신하면서 재귀호출
    }

    private static void union(int x, int y){
        int px = find(x);
        int py = find(y);
        P[py] = px; //두 번째 인자를 첫 번째 인자의 그룹으로 합침
    }
}