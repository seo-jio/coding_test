package coding_test.기타;

public class 재귀를_사용한_합_구하기 {
    public static void main(String[] args) {
        int N = 100;
        int S = 0;
        S = sumRe(N);
        System.out.println(S);
    }

    public static int sumRe(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumRe(n - 1);
    }
}
