import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1074 {
    static int N;
    static int r;
    static int c;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs  = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        r = Integer.parseInt(inputs[1]);
        c = Integer.parseInt(inputs[2]);
        findCount(0, 0, (1<<N));
        System.out.print(ans);

    }

    public static void findCount(int x, int y, int n){
        if(x == r && y == c){ //종료 조건
            return;
        }
        else{
            int temp = n * n / 4; //각 사각형의 시작점(왼쪽 위 모서리)에 해당하는 값을 찾기 위한 변수
            if(r >= x && r < x + n/2 && c >= y && c < y + n/2){ //왼쪽 위 사각형에 존재
                findCount(x, y, n/2);
                ans += temp*0;
            }
            else if(r >= x && r < x + n/2 && c >= y +n/2 && c < y + n){ //오른 쪽 위 사각형에 존재
                ans += temp*1;
                findCount(x, y+n/2, n/2);
            }else if(r >= x + n/2 && r < x + n && c >= y && c < y + n/2){ //왼쪽 아래 사각형에 존재
                ans += temp*2;
                findCount(x+n/2, y, n/2);
            }else{                                                      //오른 쪽 아래 사각형에 존재
                ans += temp*3;
                findCount(x+n/2, y+n/2, n/2);
            }
        }
        return;
    }
}