import java.util.*;
import java.io.*;

public class SWEA_요리사 {
    static int[][] synergy;
    static List<Integer> arr;  //선택한 숫자들 집합
    static List<Integer> noArr; //선택하지 않은 숫자들 집합
    static int T;
    static int N;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<T+1; tc++){
            //입력
            N = Integer.parseInt(br.readLine());
            min=Integer.MAX_VALUE/1000;
            synergy = new int[N][N];
            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    synergy[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            //로직
            arr = new ArrayList<>();
            noArr = new ArrayList<>();
            comb(0, 0);
            System.out.printf("#%d %d\n", tc, min);
        }
    }
    public static void comb(int cur, int cnt){ //현재 선택하는 숫자, 여태 껏 선택한 숫자의 개수
        if(cur == N) {
            if(cnt == N/2){
                min = Math.min(min, cal(arr, noArr));
            }
        }else{
            arr.add(cur);
            comb(cur+1, cnt+1);  //선택한 경우
            arr.remove(arr.size()-1);

            noArr.add(cur);
            comb(cur+1, cnt);  //선택하지 않은 경우
            noArr.remove(noArr.size()-1);
        }
    }

    public static int cal(List<Integer> arr, List<Integer> noArr){
        int sum1 = 0;
        int sum2 = 0;

        for(int a : arr){
            for(int b : arr){
                if(a == b) continue;
                sum1 += synergy[a][b];
            }
        }

        for(int a : noArr){
            for(int b : noArr){
                if(a == b) continue;
                sum2 += synergy[a][b];
            }
        }
        return Math.abs(sum1 - sum2);
    }
}