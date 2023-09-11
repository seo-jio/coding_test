import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TopologySort {
    static int N, M;
    static List<Integer>[] adjList;
    static int[] inDegree; //진입 차수 관리를 위한 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new List[N+1];
        for (int i = 0; i < N + 1; i++) {
            adjList[i] = new ArrayList<>();
        }
        inDegree = new int[N+1];

        int from, to;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
            inDegree[to]++; //진입 차수 증가
        }

        ArrayList<Integer> list = topologySort();
        if(list.size()==N) { //모든 정점을 방문했을 경우
            for(Integer vertex : list) {
                System.out.println(vertex+" ");
            }
            System.out.println();
        }else {
            System.out.println("cycle 발생");
        }
    }

    private static ArrayList<Integer> topologySort(){
        ArrayList<Integer> orderList = new ArrayList<>(); //방문 순서를 저장할 List

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=1; i<=N; i++) { //진입 차수가 0인 정점 큐에 넣기
            if(inDegree[i]== 0) queue.offer(i);
        }

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            orderList.add(cur);

            //현재 정점 기준으로 인접정점 처리
            for(Integer next : adjList[cur]){
                if(--inDegree[next] == 0){
                    queue.offer(next);
                }
            }
        }

        return orderList;
    }
}