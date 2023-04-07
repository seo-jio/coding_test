package 정리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//�κ� ����
public class SubSetTest {
    static int[] P = { 1, 2, 3, 4, 5 };
    static int N = P.length;
    static int R;
    static int count;
    static boolean[] visited; // depth�� ã�� ���� int�� �ϴ� ��쵵 �ִ�.

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        R = 3;
        count = 0;
        visited = new boolean[N];
        subSet(0, 0, 1);
        System.out.println(count);
    }

    // if���� ����� ��� �� ���� ��ü�� N^R �ݺ�������
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
