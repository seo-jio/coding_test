import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1541 {
    static String input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        String[] numbers = input.split("-"); // -기준으로 문자열을 split
        int length = numbers.length;

        int total = 0; // 첫 번째 덩어리 값 계산
        StringTokenizer st = new StringTokenizer(numbers[0], "+");
        while (st.hasMoreTokens()) {
            total += Integer.parseInt(st.nextToken()); // Integer.parseInt() 사용시 앞에 0(leading zero)를 없앨 수 있지만 이떄
                                                       // Integer의 범위를 생각해야한다.
        }

        for (int i = 1; i < length; i++) { // 두 번째 덩어리 부터 덩어리의 총합을 total에서 빼줌
            int subTotal = 0;
            st = new StringTokenizer(numbers[i], "+");
            while (st.hasMoreTokens()) {
                subTotal += Integer.parseInt(st.nextToken());
            }
            total -= subTotal;
        }

        System.out.println(total);
    }
}
