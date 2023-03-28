import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_Contact {
    static int T = 10;
    static int N, start;
    static List<Integer>[] graph;
    static Queue<Node> que;
    static class Node {
        int v;
        int dis;

        public Node(int v, int dis) {
            this.v = v;
            this.dis = dis;
        }
    }
    static int[] visited;  //이동 거리를 저장할 배열
    static int maxDis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc<= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());
            String[] temp = br.readLine().split(" ");
            graph = new ArrayList[101];
            for (int i = 0; i < 101; i++) {
                graph[i] = new ArrayList<>();
            }
            for(int i=0; i<=N-2; i+=2){
                int s = Integer.parseInt(temp[i]);
                int e = Integer.parseInt(temp[i+1]);
                graph[s].add(e);
            }

            maxDis = Integer.MIN_VALUE; //시작점 부터 최대 떨어진 거리를 저장할 변수 초기화
            que = new ArrayDeque<>();
            visited = new int[101]; //1~100까지 존재
            que.offer(new Node(start, 1));
            visited[start] = 1;
            bfs();

            int ans = -1;
            for (int i = 0; i < 101; i++) {
                if(visited[i] == maxDis){  //이동 거리가 최대 이동 거리와 같다면 정답 갱신
                    ans = Math.max(ans, i);
                }
            }
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs() {
        while (!que.isEmpty()){
            Node cur = que.poll();
            int v = cur.v;
            int dis = cur.dis;
            maxDis = Math.max(maxDis, dis); //최대 이동 거리 저장
            for(int next : graph[v]){
                if(visited[next] != 0) continue;
                visited[next] = dis+1; //방문하는 데 걸린 최소 이동 거리 저장
                que.offer(new Node(next, dis+1));
            }
        }
    }
}