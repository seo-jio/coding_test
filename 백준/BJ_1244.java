import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_1244 {

    static int N;  // 전구 수
    static int[] lights;  //전구 상태
    static int K; // 학생 수
    static Map<Integer, Integer> students = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        lights = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            lights[i+1] = Integer.parseInt(st.nextToken());
        }
        K = Integer.parseInt(br.readLine());
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            changeState(gender, num);
        }
        for(int i=1; i<lights.length; i++){
            System.out.printf("%d ", lights[i]);
            if(i % 20 == 0) System.out.println();
        }
    }

    public static void changeState(int gender, int num){
        if(gender == 1){ // 남학생
            int cur = num;
            while(cur <= N){
                lights[cur] = Math.abs(lights[cur] - 1);
                cur += num;
            }
        }else{           // 여학생
            int left = num;
            int right = num;
            while(left >= 1 && right <= N){
                if(lights[left] != lights[right]){
                    break;
                }
                left -= 1;
                right += 1;
            }
            left += 1;
            right -= 1;
            for(int i=left; i<=right; i++){
                lights[i] = Math.abs(lights[i] - 1);
            }
        }
    }
}

