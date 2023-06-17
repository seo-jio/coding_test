import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2252 {
    static int N, M;
    static List<Integer>[] adj;
    static int[] inDegree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N+1];
        inDegree = new int[N+1];
        for (int i = 0; i < N+1; i++) {
            adj[i] = new ArrayList<>();
        }

        //위상정렬을 위한 인접리스트, 진입차수 배열 초기화
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adj[from].add(to);
            inDegree[to]++;
        }

        List<Integer> ans = topologySort();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.size(); i++) {
            sb.append(ans.get(i)).append(" ");
        }
        System.out.println(sb);
    }

    private static List<Integer> topologySort(){
        Queue<Integer> que = new ArrayDeque<>();
        List<Integer> order = new ArrayList<>();

        //초기 진입차수가 0인 노드를 que에 추가
        for (int i = 1; i < N+1; i++) {
            if(inDegree[i] == 0){
                que.offer(i);
            }
        }

        while (!que.isEmpty()) {
            int cur = que.poll();
            order.add(cur);
            for(int next : adj[cur]){
                if(--inDegree[next] == 0){ //진입차수가 0이 되면 que에 추가
                    que.offer(next);
                }
            }
        }
        return order;
    }
}
