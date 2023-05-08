import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10996 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n == 1){
            System.out.println("*");
        }else{
            for(int i=0; i<2*n; i++){
                if(i%2 == 0){
                    for(int j=0; j<n; j++) {
                        if (j % 2 == 0) {
                            System.out.print("*");
                        } else {
                            System.out.print(" ");
                        }
                    }
                }else{
                    for(int j=0; j<n; j++){
                        if(j%2 == 0){
                            System.out.print(" ");
                        }else{
                            System.out.print("*");
                        }
                    }
                }
                System.out.println();
            }
        }
    }
}
