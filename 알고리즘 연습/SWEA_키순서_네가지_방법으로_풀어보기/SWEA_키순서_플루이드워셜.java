package SWEA_키순서_네가지_방법으로_풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_키순서_플루이드워셜 {
    static int N, M, adj[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            adj = new int[N + 1][N + 1]; // adj[i][j] == 1이면 i번째 학생보다 j번째 학생의 키가 크다.

            StringTokenizer st = null;
            int a, b;
            for (int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                adj[a][b] = 1; // 유향
            }

            // 플루이드 워셜 사용
            for (int k = 1; k <= N; k++) { // 경유(학생k)
                for (int i = 1; i <= N; i++) { // 출발(학생i)
                    if (i == k || adj[i][k] == 0)
                        continue; // 경유 효과가 없거나 i번째 학생보다 k번째 학생의 키카 크지 않은 경우는 넘어감
                    for (int j = 1; j <= N; j++) { // 도착(학생j)
                        if (adj[i][j] == 1)
                            continue; // 이미 i보다 j번째 학생의 키가 큰 걸 아는 경우 경유해볼 필요가 없다.
                        // i<k<j : 학생 i보다 학생 k가 키가 크고 학생 k보다 학생 j가 키가 크면 학생 i보다 학생 j가 키가 크다.
                        adj[i][j] = adj[i][k] & adj[k][j]; // and 연산을 통해 둘 다 1일 경우 1이 되도록 설정
                    }
                }
            }
            int ans = 0;
            for (int i = 1; i <= N; i++) {
                int cnt = 0;
                for (int j = 1; j <= N; j++) { // i번째 행(나보다 큰 학생)과 열(나보다 작은학생)을 확인
                    cnt += adj[i][j] + adj[j][i];
                }
                if (cnt == N - 1) {
                    ans++;
                }
            }

            System.out.println("#" + tc + " " + ans);
        }

    }
}
