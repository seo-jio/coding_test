import java.io.*;
import java.util.*;
public class BJ_1759 {

    static String[] choose;
    static String[] alphas;
    static String[] vowels = {"a", "e", "i", "o", "u"};
    static int L;
    static int C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        alphas = br.readLine().split(" ");
        Arrays.sort(alphas);
        choose = new String[L];
        combi(0, 0);
    }

    static void combi(int cnt, int start) { //조건 확인하는 cCl
        if(cnt==L) {
            int vowelCnt = 0;     //모음 개수
            int consonantCnt = 0; //자음 개수
            for(String s : choose){ //모음, 자음 개수 세기
                if(Arrays.asList(vowels).contains(s)){
                    vowelCnt += 1;
                }else{
                    consonantCnt += 1;
                }
            }
            if(vowelCnt >= 1 && consonantCnt >= 2){  //조건에 맞다면 출력
                for(int i=0; i< choose.length; i++){
                    System.out.printf("%s", choose[i]);
                }
                System.out.println();
            }
            return;
        }
        for (int i = start; i < C; i++) {
            choose[cnt] = alphas[i];
            combi(cnt+1, i+1);
        }
    }
}
