import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_보물상자 {
    static int T, N, K;
    static String str;
    static Set<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            str = br.readLine();

            set = new HashSet<>();
            int cnt = 0;
            while (cnt < N) {
                String temp = str.substring(cnt, cnt + N / 4);
                set.add(Integer.parseInt(temp, 16));
                cnt += N / 4;
            }
            for (int i = 0; i < N / 4 - 1; i++) {
                rotate();
                cnt = 0;
                while (cnt < N) {
                    String temp = str.substring(cnt, cnt + N / 4);
                    set.add(Integer.parseInt(temp, 16));
                    cnt += N / 4;
                }
            }
            Integer[] arr = set.toArray(new Integer[0]);
            Arrays.sort(arr, Comparator.reverseOrder());
            sb.append("#").append(tc).append(" ").append(arr[K - 1]).append("\n");
        }
        System.out.println(sb);
    }

    private static void rotate() {
        str = str.substring(str.length() - 1) + str.substring(0, str.length() - 1);
    }
}
