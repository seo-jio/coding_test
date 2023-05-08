import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_6497 {
    static int V, E;
    static List<Edge>[] adj;
    static class Edge implements Comparable<Edge>{
        int s, e;
        long w;

        public Edge(int s, int e, long w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.w, o.w);
        }
    }
    static int[] P;
    static PriorityQueue<Edge> pque;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            if(V == 0 && E == 0) break;
            pque = new PriorityQueue<>();
            long total = 0L;
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                long w = Long.parseLong(st.nextToken());
                pque.offer(new Edge(s, e, w));
                total += w;
            }
            makeSet();
            int cnt = 0;
            long sum = 0L;
            while(!pque.isEmpty()){
                if(cnt == V-1) break;
                Edge cur = pque.poll();
                if(find(cur.s) == find(cur.e)) continue; //부모가 같으면 continue
                union(cur.s, cur.e);
                sum += cur.w;
                cnt++;
            }
            System.out.println(total - sum);
        }

    }

    private static void makeSet() {
        P = new int[V];
        for (int i = 0; i < V; i++) {
            P[i] = i;
        }
    }
    private static int find(int x){
        if(x==P[x]) return x;
        return P[x] = find(P[x]);
    }

    private static void union(int x, int y){
        int px = find(x);
        int py = find(y);
        P[py] = px;
    }
}
