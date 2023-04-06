import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15961 {
    static int N, D, K, C;
    static int[] counts;
    static int[] sushi;
    static int curKindCount;
    static int maxKindCount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        sushi = new int[N];
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }
        //count 배열 초기화
        counts = new int[D + 1];
        for (int i = 0; i < K; i++) {
            int curSushi = sushi[i];
            counts[curSushi]++;
        }
        counts[C]++; //무료 초밥 고려
        curKindCount = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0) {
                curKindCount++;
            }
        }
        maxKindCount = curKindCount;
        findMaxKind();
        System.out.println(maxKindCount);
    }

    private static void findMaxKind(){
        for (int i = 1; i < N; i++) {
            int leftIdx = 0;
            int rightIdx = 0;
            if(i > N - K){ //앞쪽으로 돌아오는 경우
                int leftCount = K;
                for (int j = i; j < N; j++) {
                    leftCount--;
                }
                rightIdx = leftCount - 1;
            }else{
                rightIdx = i + K - 1;
            }
            leftIdx = i - 1;
            int leftSushi = sushi[leftIdx]; //이전에 포함되어 있던 초밥
            int lastSushi = sushi[rightIdx]; //새롭게 추가된 초밥
            counts[leftSushi]--;
            if (counts[leftSushi] == 0) { //더 이상 선택하지 않았을 경우
                curKindCount--;
            }
            counts[lastSushi]++;
            if (counts[lastSushi] == 1) { //새롭게 추가된 종류의 초밥일 경우
                curKindCount++;
            }
//            System.out.println("curKindCount = " + curKindCount);
            maxKindCount = Math.max(maxKindCount, curKindCount);
        }
    }
}
