import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1753 {
    static int V, E;
    static int start;
    static class Edge implements Comparable<Edge>{
        int e;
        int w;

        public Edge(int e, int w) {
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }
    static List<Edge>[] edges;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        edges = new ArrayList[V + 1];
        for (int i = 0; i < V + 1; i++) {
            edges[i] = new ArrayList<>();
        }
        for(int i=0; i<E; i++){
            String[] temp = br.readLine().split(" ");
            int s = Integer.parseInt(temp[0]);
            int e = Integer.parseInt(temp[1]);
            int w = Integer.parseInt(temp[2]);
            edges[s].add(new Edge(e, w));
        }

        visited = new boolean[V + 1];
        distance = new int[V + 1];
        Arrays.fill(distance, Integer.MAX_VALUE / 1000);
        distance[start] = 0;
        for (int i = 1; i <= V; i++) {
            int cur = -1;
            int minDis = Integer.MAX_VALUE;
            for (int j = 1; j <= V; j++) {
                if(!visited[j] && minDis > distance[j]){
                    cur = j;
                    minDis = distance[j];
                }
            }
            if(cur == -1) break;
            visited[cur] = true;

            for(Edge next : edges[cur]){
                if(!visited[next.e] && distance[next.e] > distance[cur] + next.w){
                    distance[next.e] = distance[cur] + next.w;
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if(distance[i] == Integer.MAX_VALUE/1000){
                System.out.println("INF");
            }else{
                System.out.println(distance[i]);
            }
        }
    }

}
