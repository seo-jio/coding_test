package SWEA_키순서_네가지_방법으로_풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//dfs 활용
public class SWEA_키순서_DFS_역인접행렬 {
    static int N, M, cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            int[][] adj = new int[N+1][N+1];
            int[][] radj = new int[N+1][N+1]; //역행렬
            StringTokenizer st = null;
            int a, b;
            for (int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                radj[b][a] = adj[a][b] = 1; //키가 작은 경우, 키가 큰 경우를 따로 표시
            }

            int ans = 0;
            for (int i = 1; i <= N; i++) {
                cnt = 0;
                dfs(i, adj, new boolean[N+1]);
                dfs(i, radj, new boolean[N+1]);
                if (cnt == N - 1) {
                    ans++;
                }
            }
            System.out.println("#"+tc+" "+ans);
        }

    }

    private static void dfs(int cur, int[][] adj, boolean[] visited){
        // adj : 자신보다 큰 관계 인접행렬이면 자신보다 큰 정점 탐색
        // radj : 자신보다 작은 관계 인접행렬이면 자신보다 큰 정점 탐색
        visited[cur] = true;
        for (int i = 1; i <= N; i++) {
            if(adj[cur][i] == 1 && !visited[i]){ //인접한 노드 중 키가 더 크고 방문하지 않았다면
                cnt++; //자기 자신은 제외하기 위해 dfs 호출 직전에 cnt 증가
                dfs(i, adj, visited);
            }
        }
    }
}