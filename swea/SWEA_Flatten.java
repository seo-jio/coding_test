import java.util.*;
import java.io.*;
import java.util.stream.IntStream;

public class SWEA_Flatten {
    static int[] boxes;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int tc=1; tc<=10; tc++){
            cnt = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            boxes = new int[100];
            for(int i=0; i<100; i++){
                boxes[i] = Integer.parseInt(st.nextToken());
            }

            int ans = -1;
            for(int i=0; i<cnt; i++){
                int temp = dump();
                if(temp != -1){
                    ans = temp;
                    break;
                }
            }
            if(ans != -1){
                System.out.printf("#%d %d\n", tc, ans);
            }else{
                int max = Arrays.stream(boxes).max().getAsInt();
                int min = Arrays.stream(boxes).min().getAsInt();
                System.out.printf("#%d %d\n", tc, max-min);
            }

        }
    }

    public static int dump(){
        int max = Arrays.stream(boxes).max().getAsInt();
        int min = Arrays.stream(boxes).min().getAsInt();

        int max_idx = IntStream.range(0, boxes.length).filter(i -> boxes[i] == max).findFirst().orElse(-1);
        int min_idx = IntStream.range(0, boxes.length).filter(i -> boxes[i] == min).findFirst().orElse(-1);

        if(boxes[max_idx] - boxes[min_idx] <= 1){
            return boxes[max_idx] - boxes[min_idx];
        }

        boxes[max_idx] -= 1;
        boxes[min_idx] += 1;
        return -1;
    }
}
