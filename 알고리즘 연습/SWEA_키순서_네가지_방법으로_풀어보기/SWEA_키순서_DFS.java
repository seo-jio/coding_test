package SWEA_키순서_네가지_방법으로_풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//dfs 활용
public class SWEA_키순서_DFS {
    static int N, M, adj[][], cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            adj = new int[N+1][N+1];
            StringTokenizer st = null;
            int a, b;
            for (int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                adj[a][b] = 1; //유향
            }

            int ans = 0;
            for (int i = 1; i <= N; i++) {
                cnt = 0;
                gtDFS(i, new boolean[N+1]);
                ltDFS(i, new boolean[N+1]);
                if (cnt == N - 1) {
                    ans++;
                }
            }
            System.out.println("#"+tc+" "+ans);
        }

    }

    private static void gtDFS(int cur, boolean[] visited){
        // cur 정점 기준으로 자신보다 큰 정점 탐색
        visited[cur] = true;
        for (int i = 1; i <= N; i++) {
            if(adj[cur][i] == 1 && !visited[i]){ //인접한 노드 중 키가 더 크고 방문하지 않았다면
                cnt++; //자기 자신은 제외하기 위해 dfs 호출 직전에 cnt 증가
                gtDFS(i, visited);
            }
        }
    }

    private static void ltDFS(int cur, boolean[] visited){
        // cur 정점 기준으로 자신보다 작은 정점 탐색
        visited[cur] = true;
        for (int i = 1; i <= N; i++) {
            if(adj[i][cur] == 1 && !visited[i]){ //인접한 노드 중 키가 더 크고 방문하지 않았다면
                cnt++; //자기 자신은 제외하기 위해 dfs 호출 직전에 cnt 증가
                ltDFS(i, visited);
            }
        }
    }
}