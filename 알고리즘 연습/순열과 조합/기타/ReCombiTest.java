package 기타;
import java.util.Arrays;

//중복 조합
public class ReCombiTest {
    static int [] p= {1,2,3,4,5};
    static int N=p.length;
    static int R;
    static int[] nums;
    static boolean [] visited;
    static int count;
    public static void main(String[] args) {
        R=3;
        visited=new boolean[N];
        nums = new int[R];
        count=0;
        combi(0,0);
        System.out.println(count);
    }
    static void combi(int cnt, int start) { //cnt : 여태 선택한 숫자의 개수, start : 조합 시도할 원소의 시작 인덱스
        if(cnt==R) {
            count++;
            System.out.println(Arrays.toString(nums)); //방문한 값들 출력
            for (int i = 0; i < N; i++) {        //방문하지 않은 값들 출력
                if(!visited[i])System.out.printf(p[i]+" ");
            }
            System.out.println();
            return;
        }
        //조합을 구할 때 선택한 값과 선택하지 않은 값이 필요하다면 visited 사용. 그렇지 않다면 필요 없다.
        //현재 선택한 수보다 더 큰 수에서만 고르기 위해 for문이 cur 부터 주어진 범위(N)까지 돌게 된다.
        //이로 인해 별도의 방문 배열 처리를 하지 않아도 된다.(어짜피 더 큰수를 보기 때문에 같을 수가 없어서)
        for (int i = start; i < N; i++) {
            visited[i]=true;  //생략 가능
            nums[cnt] = p[i];
            combi(cnt+1, i); // 중복 조합이기 때문에 두 번째 인자가 그냥 i이다!!!
            visited[i]=false; // 생략 가능
        }
    }

}