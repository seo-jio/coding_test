package 정리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//부분 집합
public class SubSetTest {
    static int[] P = { 1, 2, 3, 4, 5 };
    static int N = P.length;
    static int R;
    static int count;
    static boolean[] visited; // depth를 찾을 때는 int로 하는 경우도 있다.

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        R = 3;
        count = 0;
        visited = new boolean[N];
        subSet(0, 0, 1);
        System.out.println(count);
    }

    // if문에 결과를 골라낼 뿐 실행 자체는 N^R 반복하지만
    private static void subSet(int cnt, int sum, int mul) {
        if (cnt == N) {
            count++;
            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    System.out.print(P[i] + " ");
                }
            }
            System.out.println();
            System.out.println("sum : " + sum);
            System.out.println("mul : " + mul);
            System.out.println("======================");
            return;
        }
        visited[cnt] = true;
        subSet(cnt + 1, sum + P[cnt], mul * P[cnt]);
        visited[cnt] = false;
        subSet(cnt + 1, sum, mul);
    }
}