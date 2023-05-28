import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 단방향그래프에서싸이클찾기 {
    static int T, N;
    static boolean[] visited;
    static int[] parents;
    static boolean[] isAlreadyChecked;
    static List<Integer>[] edges;
    static int students;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());

            edges = new List[N + 1]; //인접 리스트로 그래프 표현
            for (int i = 0; i < N + 1; i++) {
                edges[i] = new ArrayList<>();
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int start = 1; start < N+1; start++) { //간선 정보 입력
                int end = Integer.parseInt(st.nextToken());
                edges[start].add(end);
            }

            students = 0;
            visited = new boolean[N + 1]; //방문 여부 저장
            isAlreadyChecked = new boolean[N + 1]; //이미 확인한 노드인지 여부 저장
            for (int i = 1; i < N+1; i++) { //연결되어 있지 않는 노드가 존재할 수 있으므로 dsfAll 수행
                if(!visited[i]){
                    parents = new int[N+1]; //DFS Tree에서 자신의 부모 노드를 저장
                    visited[i] = true;
                    parents[i] = i;
                    dfs(i);
                }
            }
            sb.append(N-students).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int start){ //Back Edge가 존재한다는 건 싸이클이 존재한다는 의미이다.
        for(int end : edges[start]){
            if (!visited[end]) { //방문하지 않았던 곳이라면
                visited[end] = true;
                parents[end] = start; //부모 노드 지정
                dfs(end);
            }
            if(visited[end] && !isAlreadyChecked[end]){ //이전에 확인하지 않았고 방문한 곳에 재방문 하는 경우라면 => 싸이클 발생
                if(start == end){ //자기 자신으로 오는 간선일 경우
                    students += 1;
                }else{
                    findParent(start);
                }
            }
            isAlreadyChecked[start] = true;
        }
    }

    private static void findParent(int end) {
        students += 1;
        if(end == parents[end]){
            return;
        }
        findParent(parents[end]);
    }
}