import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//순열
public class SWEA_규영이와인영이의카드게임 {
    static int T;
    static Set<Integer> nums;
    static int[] aCards;
    static int[] bCards;
    static boolean visited[];
    static int[] orders;
    static int win;
    static int loose;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int tc = 1; tc <= T; tc++) {
            nums = new HashSet<>();
            for (int i = 1; i <= 18; i++) {
                nums.add(i);
            }
            aCards = new int[9];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 9; i++) {
                aCards[i] = Integer.parseInt(st.nextToken());
            }
            for (int i : aCards) {
                if (nums.contains(i)) {
                    nums.remove(i);
                }
            }
            bCards = new int[9];
            int cnt = 0;
            for (int i : nums) {
                bCards[cnt++] = i;
            }

            win = 0;
            loose = 0;
            visited = new boolean[9];
            orders = new int[9];
            perm(0);
            System.out.printf("#%d %d %d\n", tc, win, loose);
        }
    }

    private static void perm(int cnt) { // 순열
        if (cnt == 9) {
            cal(aCards, orders);
            return;
        }
        for (int i = 0; i < 9; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            orders[cnt] = bCards[i];
            perm(cnt + 1);
            visited[i] = false;
        }
    }

    private static void cal(int[] aCards, int[] orders) { // 승패 가리기
        int aSum = 0;
        int bSum = 0;
        for (int i = 0; i < 9; i++) {
            if (aCards[i] > orders[i]) {
                aSum += aCards[i] + orders[i];
            } else {
                bSum += aCards[i] + orders[i];
            }
        }
        if (aSum > bSum) {
            win++;
        } else if (aSum < bSum) {
            loose++;
        }
    }
}
