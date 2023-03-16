import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_수영장 {
    static int T;
    static int[] costs;
    static int[] months;
    static int minCost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <=T; tc++){
            String[] temp = br.readLine().split(" ");
            costs = new int[4];
            for(int i=0; i<4; i++){
                costs[i] = Integer.parseInt(temp[i]);
            }
            temp = br.readLine().split(" ");
            months = new int[12];
            for(int i=0; i<12; i++){
                months[i] = Integer.parseInt(temp[i]);
            }

            minCost = costs[3]; //1년 이용권을 사용했을 때를 초기값으로 지정
            solve(0, 0);
            sb.append("#").append(tc).append(" ").append(minCost).append("\n");
        }
        System.out.println(sb);
    }

    private static void solve(int cnt, int sum) {
        if(cnt >= 12){
            minCost = Math.min(minCost, sum);
            return;
        }
        solve(cnt+1, sum + months[cnt]*costs[0]); //1일 이용권
        solve(cnt+1, sum + costs[1]);             //1달 이용권
        solve(cnt+3, sum+costs[2]);               //3달 이용권
    }
}
