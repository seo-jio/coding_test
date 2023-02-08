import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BJ_1789 {
    static int S;
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        long S = sc.nextLong();
        Long cnt = 1L;
        Long sum = 0L;
        while(true) {
            sum += cnt;
            if (sum > S) {
                break;
            }
            cnt++;
        }
        System.out.println(cnt-1);
    }
}
