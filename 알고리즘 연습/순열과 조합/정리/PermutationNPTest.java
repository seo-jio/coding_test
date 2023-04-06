package 정리;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationNPTest {
    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] input = new int[N];
        for(int i=0; i<N; i++) {
            input[i] = sc.nextInt();
        }
        Arrays.sort(input);
        do {
            System.out.println(Arrays.toString(input));
            cnt++;
        }while(np(input));
        System.out.println(cnt);
    }

    private static boolean np(int[] input) {
        int n = input.length;
        //step1. 뒤쪽 부터 꼭대기를 찾는다.(꼭대기 바로 앞이 교환할 자리)
        int i = n-1;
        while(i>0 && input[i-1] >= input[i]) { //i가 0일 경우 i-1을 참조해서 index가 배열 범위를 넘어버려 i>0이라는 조건 추가
            --i; //전위, 후위 차이가 존재하지 않는다.
        }
        if(i==0) return false; //교환할 위치가 없다는 건 이미 사전순으로 최대 값을 찾은 것과 같다(내림차순 정렬)

        //step2 꼭대기 바로 앞(i-1)자리에 교환할 값을 뒤쪽부터 찾는다.
        int j = n-1;
        while(input[i-1] >= input[j]) {
            --j;
        }

        //step3 꼭대기 바로 앞(i-1)자리와 그 자리값보다 한 단계 큰 자리(j) 수와 교환
        swap(input, i-1, j);

        //step4. 꼭대기 부터 맨 뒤까지 오름차순 정렬
        int k = n-1;
        while(i < k) {
            swap(input, i++, k--);
        }
        return true;
    }

    //swap 하는 함수
    private static void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}

