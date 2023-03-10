import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//시뮬레이션
public class SWEA_배틀필드 {

    static int T;
    static int H;
    static int W;
    static int N;
    static String[][] grid;
    static String[] commands;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int curDir;
    static int x;
    static int y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            //입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            grid = new String[H][W];
            for(int i=0; i<H; i++){
                String[] temp = br.readLine().split("");
                for(int j=0; j<W; j++){
                    grid[i][j] = temp[j];
                    if(grid[i][j].equals("<")){
                        curDir = 3;
                        x = i;
                        y = j;
                    }else if(grid[i][j].equals(">")){
                        curDir = 1;
                        x = i;
                        y = j;
                    }else if(grid[i][j].equals("^")){
                        curDir = 0;
                        x = i;
                        y = j;
                    }else if(grid[i][j].equals("v")){
                        curDir = 2;
                        x=i;
                        y=j;
                    }
                }
            }
            N = Integer.parseInt(br.readLine());
            commands = br.readLine().split("");
            //로직
            for(int k=0; k<N; k++){
                action(commands[k]);
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<H; i++){
                for(int j=0; j<W; j++){
                    sb.append(grid[i][j]);
                }
                sb.append("\n");
            }
            System.out.printf("#%d %s", tc, sb.toString());
        }
    }

    private static void action(String command) {
        if(command.equals("S")){  //Shoot 명령어
            int start;
            if(curDir == 0){
                start = x;
                while(start >= 0){
                    if(grid[start][y].equals("#")) break;
                    if(grid[start][y].equals("*")){
                        grid[start][y] = ".";
                        break;
                    }
                    start--;
                }
            }else if(curDir == 1){
                start = y;
                while(start < W){
                    if(grid[x][start].equals("#")) break;
                    if(grid[x][start].equals("*")){
                        grid[x][start] = ".";
                        break;
                    }
                    start++;
                }
            }else if(curDir == 2){
                start = x;
                while(start < H){
                    if(grid[start][y].equals("#")) break;
                    if(grid[start][y].equals("*")){
                        grid[start][y] = ".";
                        break;
                    }
                    start++;
                }
            }else{
                start = y;
                while(start >= 0){
                    if(grid[x][start].equals("#")) break;
                    if(grid[x][start].equals("*")){
                        grid[x][start] = ".";
                        break;
                    }
                    start--;
                }
            }
        }else{  //U, R, L, D 명령어
            if(command.equals("U")){
                curDir = 0;
                grid[x][y] = "^";
            }else if (command.equals("D")) {
                curDir = 2;
                grid[x][y] = "v";
            }else if (command.equals("L")) {
                curDir = 3;
                grid[x][y] = "<";
            }else if (command.equals("R")) {
                curDir = 1;
                grid[x][y] = ">";
            }
            int nx = x + dx[curDir];
            int ny = y + dy[curDir];
            if(canGo(nx, ny)){
                switch (curDir){
                    case 0: grid[nx][ny] = "^";
                            grid[x][y] = ".";
                        break;
                    case 1: grid[nx][ny] = ">";
                            grid[x][y] = ".";
                        break;
                    case 2: grid[nx][ny] = "v";
                            grid[x][y] = ".";
                        break;
                    case 3: grid[nx][ny] = "<";
                            grid[x][y] = ".";
                        break;
                }
                x = nx;
                y = ny;
            }
        }

    }

    private static boolean inRange(int x, int y){
        return x >= 0 && x < H && y >= 0 && y < W;
    }

    private static boolean canGo(int x, int y){
        if(inRange(x, y) && grid[x][y].equals(".")){
            return true;
        }
        return false;
    }
}
