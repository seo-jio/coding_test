import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_9205 {
    static int T, N;
    static Node[] nodes;
    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static List<Integer>[] adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());
            nodes = new Node[N + 2];  //시작점 : 0번, 도착점 : N+1번, 편의점 : 1~N번
            for (int i = 0; i < N + 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                nodes[i] = new Node(x, y);
            }

            //인접리스트로 그래프 표현
            adj = new List[N + 2];
            for (int i = 0; i < N + 2; i++) {
                adj[i] = new ArrayList<>();
            }
            for (int s = 0; s < N + 2; s++) {
                for (int e = 0; e < N + 2; e++) {
                    if(s == e) continue;
                    Node start = nodes[s];
                    Node end = nodes[e];
                    if(Math.abs(start.x - end.x) + Math.abs(start.y - end.y) <= 1000){ //맥주 20병으로 갈 수 있는 경우 간선 추가
                        adj[s].add(e);
                    }
                }
            }

            if(bfs()){
                sb.append("happy").append("\n");
            }else{
                sb.append("sad").append("\n");
            }
        }
        System.out.println(sb);
    }

    private static boolean bfs() {
        boolean[] visited = new boolean[N+2];
        Queue<Integer> que = new LinkedList<>();
        que.offer(0);
        visited[0] = true;
        while(!que.isEmpty()) {
            int start = que.poll();
            for (int i = 0; i < adj[start].size(); i++) { //인접리스트를 확인하여 갈 수 있는 노드들 순회
                int end = adj[start].get(i);
                if(visited[end]) continue; //이미 방문했다면
                visited[end] = true;
                que.offer(end);
            }
        }
        if (visited[N + 1]) { //도착지에 방문했다면 true return
            return true;
        }
        return false;
    }
}