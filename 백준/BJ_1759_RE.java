import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//기존 수행시간 개선 및 조합 연습
public class BJ_1759_RE {
    static int L, C;
    static char[] inputs;
    static char[] nums;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static Set<Character> consonants = new HashSet<>(); //모음을 담고 있는 set

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        String[] temp = br.readLine().split(" ");
        String t = String.join("", temp);
        inputs = new char[C];
        for (int i = 0; i < C; i++) {
            inputs[i] = t.charAt(i);
        }
        Arrays.sort(inputs); //입력 정렬
        consonants.add('a'); //모음 추가
        consonants.add('e');
        consonants.add('i');
        consonants.add('o');
        consonants.add('u');
        nums = new char[L];
        visited = new boolean[C];
        combi(0, 0);
        System.out.println(sb);
    }

    private static void combi(int cnt, int start) { //조합
        if(cnt == L){
            if(check(nums)){ //조건에 맞는지 확인
                String str = new String(nums);
                sb.append(str).append("\n");
            }
            return;
        }
        for(int i=start; i<C; i++){
            nums[cnt] = inputs[i];
            combi(cnt+1, i+1);
            nums[cnt] = 0;
        }
    }

    private static boolean check(char[] nums) {
        int conCnt = 0; //모음 개수
        int voCnt = 0;  //자음 개수
        for(int i=0; i<L; i++){
            if(consonants.contains(nums[i])) conCnt++;
        }
        voCnt = L - conCnt;
        return conCnt >= 1 && voCnt >= 2;
    }


}
