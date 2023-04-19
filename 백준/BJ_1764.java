import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1764 {
    static int N, K;
    static Set<String> people;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        people = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            people.add(name);
        }

        List<String> choosed = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < K; i++) {
            String name = br.readLine();
            if (people.contains(name)) {
                count++;
                choosed.add(name);
            }
        }

        Collections.sort(choosed);
        System.out.println(choosed.size());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < choosed.size(); i++) {
            sb.append(choosed.get(i)).append("\n");
        }
        System.out.println(sb);
    }
}
