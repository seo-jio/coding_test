import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//코드 단순화
public class BJ_1074 {
    private static int N, r, c;
    private static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        solve(0, 0, 1<<N, 0);
        System.out.println(ans);
    }

    private static void solve(int x, int y, int size, int start) {
        if (x == r && y == c) {
            ans = start;
            return;
        }
        if(r >= x && r < x+size && c >= y && c < y+size){
            int n = size/2;
            solve(x, y, size/2, start+(n*n*0));
            solve(x, y+size/2, size/2, start+(n*n*1));
            solve(x+size/2, y, size/2, start+(n*n*2));
            solve(x+size/2, y+size/2, size/2, start+(n*n*3));
        }
    }
}