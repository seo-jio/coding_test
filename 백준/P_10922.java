import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_10922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){  //앞 공백
            for(int j=0; j<n-i-1; j++){
                System.out.print(" ");
            }
            if(i==0){  //첫 줄
                System.out.print("*");
            }else if(i == n-1){  //마지막 줄
                for(int j=0; j<2*n-1; j++) {
                    System.out.print("*");
                }
            }else{  //중간 줄
                System.out.print("*");
                for(int j=0; j<2*i-1; j++){
                    System.out.print(" ");
                }
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
