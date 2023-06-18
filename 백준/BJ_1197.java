import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1197 {
    static int V, E;
    static long min;
    static int[] p;
    static int[] r;
    static class Edge implements Comparable<Edge>{
        int s;
        int e;
        int weight;

        public Edge(int s, int e, int weight) {
            this.s = s;
            this.e = e;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    static PriorityQueue<Edge> points;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        points = new PriorityQueue<>(); //가중치의 오름차순으로 정렬하기 위해 우선순위 큐 사용
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            points.offer(new Edge(s, e, w));
        }
        p = new int[V+1];   //최상위 노드(최종 보스)가 몇 번 노드인지 저장
        r = new int[V + 1]; //부하의 개수를 의미한다.
        makeSet();          //배열 초기화

        min = 0;
        int cnt = 0;
        while(cnt!=V-1){
            Edge edge = points.poll();
            if(union(edge.s, edge.e)){
                cnt++;
                min+=edge.weight;
            }
        }
        System.out.println(min);
    }

    private static boolean union(int x, int y) { //작은 세력을 큰 세력에 붙여준다.
        x = find(x); //최상위 부모 탐색
        y = find(y);
        if(x==y) return false;
        if(r[x] < r[y]){  //y 그룹이 더 큰 경우
            r[y] += r[x]; //r[y]++해도 상관없지만
            p[x] = y;     //큰 세력의 최상위 노드를 작은 세력의 최상위 노드의 부모로 설정
        }else{
            r[x] += r[y]; //x 그룹이 더 큰 경우
            p[y] = x;
        }
        return true;
    }

    private static int find(int x) { //현재 노드(x)가 속한 그룹의 최상위 노드를 찾는다.
        if(x == p[x]) return x;
        else return p[x] = find(p[x]);
    }

    private static void makeSet() {
        for(int i=0; i<V+1; i++){
            p[i] = i;  //초기에는 각 노드의 최상위 부모를 자기 자신으로 설정
            r[i] = 1;  //초기에는 각 노드의 부하수가 모두 1로 설정
        }
    }
}