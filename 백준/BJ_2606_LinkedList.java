import java.util.*;

public class BJ_2606_LinkedList {
    static int N, M;
    static List<Integer>[] lists;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        lists = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            lists[s].add(e);
            lists[e].add(s);
        }

        visited = new boolean[N];
        visited[0] = true;
        bfs(0);

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if(visited[i]) cnt++;
        }
        System.out.println(cnt-1);
    }

    private static void bfs(int s) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(s);
        visited[s] = true;
        while(!que.isEmpty()){
            int start = que.poll();
            for(int e : lists[start]){
                if(visited[e]) continue;
                que.offer(s);
                visited[s] = true;
            }
        }
    }
}
