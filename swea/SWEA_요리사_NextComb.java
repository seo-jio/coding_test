import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_요리사_NextComb {
    static int[][] synergy;
    static List<Integer> arr;  //선택한 숫자들 집합
    static List<Integer> noArr; //선택하지 않은 숫자들 집합
    static int[] p;
    static int[] nums;
    static int T;
    static int N;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc < T + 1; tc++) {
            //입력
            N = Integer.parseInt(br.readLine());
            min = Integer.MAX_VALUE / 1000;
            //p 배열 초기화
            p = new int[N];
            for (int i = N - 1; i >= N / 2; i--) {
                p[i] = 1;
            }
            //nums 배열 초기화
            nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = i;
            }
            //synergy 배열 초기화
            synergy = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    synergy[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            //로직
            do {
                //초기화를 여기서 해야 됨에 유의하자!!
                arr = new ArrayList<>();
                noArr = new ArrayList<>();
                for (int i = 0; i < N; i++) {
                    if (p[i] == 1) {
                        arr.add(i);
                    } else {
                        noArr.add(i);
                    }
                }
                min = Math.min(min, cal(arr, noArr));
            } while (nextComb(N - 1));
            System.out.printf("#%d %d\n", tc, min);
        }
    }

    //nextCombination을 사용
    public static boolean nextComb(int size){
        //꼭대기를 찾는 코드(내림차순이 깨지는 위치)
        int i = size;
        while(i > 0 && p[i-1] >= p[i]){
            i--;
        }
        if(i==0){ //이미 내림차순으로 정렬되서 제일 앞까지 갔을 때 함수를 종료
            return false;
        }
        int j = size;
        while(p[i-1] >= p[j]){
            j--;
        }
        //swap해주는 코드
        int temp;
        temp = p[i-1];
        p[i-1] = p[j];
        p[j] = temp;

        int k = size;
        while(i < k){
            temp = p[i];
            p[i] = p[k];
            p[k] = temp;
            i++;
            k--;
        }
        return true;
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
