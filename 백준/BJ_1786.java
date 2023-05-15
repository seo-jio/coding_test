import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1786 {
    static int M, N;
    static String text, patterns;
    static int[] f = new int[10000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        text = br.readLine();
        patterns = br.readLine();
        N = text.length();
        M = patterns.length();
        text = "#" + text;
        patterns = "#" + patterns;

        //1. failure function 값 계산
        f[0] = -1;
        for (int i = 1; i <= M; i++) {
            int j = f[i - 1];
            while (j >= 0 && patterns.charAt(i) != patterns.charAt(j + 1)) {
                j = f[j];
            }
            f[i] = j + 1;
        }

        StringBuilder sb = new StringBuilder();
        int ans = 0;

        int j = 0;
        for (int i = 1; i <= N; i++) {
            while (j >= 0 && text.charAt(i) != patterns.charAt(j + 1)) {
                j = f[j];
            }
            j++; //일치하거나 매칭이 안된 경우 j + 1
            if(j == M){ //매칭이 됐더라도 이후를 계속 탐색한다.
                ans ++;
                j = f[j];
                sb.append(i+1-M).append(" ");
            }
        }
        System.out.println(ans);
        System.out.println(sb);
    }
}
