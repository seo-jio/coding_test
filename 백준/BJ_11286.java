import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//객체 비교(Comparator, Comparable)
public class BJ_11286 {
    static int N;
    static StringTokenizer st;
    static class MyComp implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            int t1 = Math.abs((Integer) o1);
            int t2 = Math.abs((Integer) o2);
            if(t1 == t2){
                return (Integer) o1 - (Integer) o2;
            }
            //직접 빼도 되지만 2^31-(-2^31)일 경우 오작동할 경우가 있어 Integer.commpare를 사용한다.
            return Integer.compare(t1, t2);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new PriorityQueue<>(new MyComp());
        for(int i=0; i<N; i++){
            int temp = Integer.parseInt(br.readLine());
            if(temp == 0){
                if(queue.size() == 0){
                    System.out.println(0);
                }else{
                    System.out.println(queue.poll());
                }
            }else{
                queue.offer(temp);
            }
        }
    }
}
