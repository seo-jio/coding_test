import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_1931 {
    static int N;
    static Pair[] pairs;

    static class Pair implements Comparable<Pair> {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o) { // 도착시간으로 정렬 후 도착시간이 같다면 출발 시간으로 정렬
            if (this.y == o.y) {
                return Integer.compare(this.x, o.x);
            }
            return Integer.compare(this.y, o.y);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pairs = new Pair[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pairs[i] = new Pair(x, y);
        }
        Arrays.sort(pairs);
        System.out.println(findMaxMeetings());
    }

    private static int findMaxMeetings() {
        int cur = pairs[0].y;
        int count = 1;
        for (int i = 1; i < N; i++) { // 회의 시작시간이 이전에 선택한 회의 종료 시간보다 이르면 선택 X
            if (pairs[i].x >= cur) {
                count++;
                cur = pairs[i].y;
            }
        }
        return count;
    }
}
