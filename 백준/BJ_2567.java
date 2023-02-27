import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2567 {
	
	static int N;
	static int[][] grid;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		grid = new int[100+2][100+2]; //격자의 둘레를 0으로 채워준다. 흰색 : 0, 검은색 : 1
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for(int j=0; j<10; j++) { //x,y부터 x+10, y+10까지 격자를 1로 채워줌
				for(int k=0; k<10; k++) {
					grid[x+j][y+k] = 1;
				}
			}
		}
		int ans = 0;
		for(int i=1; i<=100; i++) {
			for(int j=1; j<=100; j++) {
				if(grid[i][j] == 1) { //검은색 스카프가 존재한다면
					for(int d=0; d<4; d++) { //4방 탐색
						int nx = i + dx[d];
						int ny = j + dy[d];
						if(grid[nx][ny] == 0) { //주변에 흰색 스카프가 있다면 ans 증가
							ans++;
						}
					}	
				}
			}
		}
		System.out.println(ans);
	}	
}