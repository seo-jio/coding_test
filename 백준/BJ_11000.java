import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_11000 {
    static int N;
    static Pair[] pairs;
    static class Pair implements Comparable<Pair>{
        int start, end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Pair p) {
            return this.start - p.start;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pairs = new Pair[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pairs[i] = new Pair(start, end);
        }
        Arrays.sort(pairs);

        PriorityQueue<Integer> endTimes = new PriorityQueue<>();
        endTimes.offer(pairs[0].end);
        for (int i = 1; i < N; i++) {
            endTimes.offer(pairs[i].end);
            if(pairs[i].start >= endTimes.peek()){
                endTimes.poll();
            }
        }
        System.out.println(endTimes.size());
    }
}