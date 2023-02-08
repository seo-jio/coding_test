//부분집합, nC0+nC1+...nCn= 2^n
public class PowerTest {
    static int [] p= {1,2,3,4,5};
    static int N=p.length;
    static boolean [] visited;
    static int count;
    public static void main(String[] args) {
        visited=new boolean[N];
        count=0;
        power(0,0, 1);
        System.out.println(count);
    }
    // 집합 set 부분집합 멱집합 {1, 2, 3}
    // {}
    // {1} {2} {3}
    // {1, 2} {1, 3} {2 3}
    // {1 2 3}
    // 2^3 = 3C0 + 3C1 + 3C2 + 3C3
    static void power(int cnt, int tot, int mul) { //tot : 부분집합의 합, mul : 부분집합의 곱
        if(cnt==N) {
            count++;
            for (int i = 0; i < N; i++) {
                if(visited[i]) {
                    System.out.printf("%d ",p[i]);
                }
            }
            if(tot == 0){ // 공집합일 경우 곱이 1이 나오는 걸 방지하기 위해 추가
                mul = 0;
            }
            System.out.println();
            System.out.println("tot :"+tot+" mul : " + mul);
            System.out.println("=====================");
            return ;
        }
        visited[cnt]=true;
        power(cnt+1,tot+p[cnt], mul*p[cnt]); //선택 했을 경우
        visited[cnt]=false;
        power(cnt+1,tot, mul);                        //선택하지 않았을 경우
    }

}