import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_11779 {
    static int V, E, from, to;
    // 최대 비용 결정 시 모든 노드가 한 줄로 이어진 경우 최대 비용이 "1000 * 100000"이 될수도 있으므로
    // Integer.MAX_VALUE가 21억 이어서 "Integer.MAX_VALUE / 1000"을 하면 2000만까지 밖에 표현할 수 없어 overflow가 나서 틀리게 된다...!
    static int MAX = Integer.MAX_VALUE / 100;
    static List<Element>[] adj;
    static PriorityQueue<Element> pque;
    static class Element {
        int index, dist;

        public Element(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }
    }
    static int[] dis, path;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());

        // 1. 인접 리스트로 그래프 표현
        adj = new List[V + 1];
        for (int i = 0; i < V + 1; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            adj[start].add(new Element(end, dist));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        from = Integer.parseInt(st.nextToken());
        to = Integer.parseInt(st.nextToken());

        dijkstra(from);

        System.out.println(dis[to]);

        int cur = to; // 도착지 부터 시작하여 출발지 까지 경로 역추적
        List<Integer> min_path = new ArrayList<>();
        while (cur != 0) {
            min_path.add(cur);
            cur = path[cur];
        }

        System.out.println(min_path.size());

        StringBuilder sb = new StringBuilder();
        for (int i = min_path.size()-1; i >= 0 ; i--) {
            sb.append(min_path.get(i)).append(" ");
        }
        System.out.println(sb);
    }

    private static void dijkstra(int start){
        dis = new int[V + 1];
        path = new int[V + 1]; // path[i] : i 노드까지 최소 비용으로 이동 시 i 노드 방문 직전에 들르는 노드 번호
        for (int i = 0; i <= V; i++) {
            dis[i] = MAX;
        }

        pque = new PriorityQueue<>((x, y) -> x.dist - y.dist);
        pque.offer(new Element(start, 0));
        dis[start] = 0;

        while (!pque.isEmpty()) {
            Element cur = pque.poll();
            int index = cur.index;
            int dist = cur.dist;
            if (dis[index] < dist) { // pque에 남아있는 잔재라면 continue
                continue;
            }

            if(index == to){ // 도착지에 도달한 경우 break
                break;
            }

            for (Element element : adj[index]) {
                int nextIndex = element.index;
                int nextDist = element.dist;

                int newDist = dis[index] + nextDist;
                if (dis[nextIndex] > newDist) {
                    dis[nextIndex] = newDist;
                    path[nextIndex] = index;
                    pque.offer(new Element(nextIndex, newDist));
                }
            }
        }
    }
}
