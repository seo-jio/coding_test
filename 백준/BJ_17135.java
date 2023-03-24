import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class BJ_17135 {
    static int N, M, D;
    static int[][] grid;
    static int[][] copy;
    static int enemy;
    static int maxKill;
    static Set<Pair> pairs;
    static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        D = Integer.parseInt(temp[2]);
        grid = new int[N][M];
        enemy = 0;
        for (int i = 0; i < N; i++) {
            temp = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(temp[j]);
                if(grid[i][j] == 1) enemy++;
            }
        }

        maxKill = Integer.MIN_VALUE;
        for (int i = 0; i < M; i++) {  //mC3 for문으로 구현
            for (int j = i+1; j < M; j++) {
                for (int k = j+1; k < M; k++) {
                    maxKill = Math.max(maxKill, simulation(i, j, k));
                }
            }
        }
        System.out.println(maxKill);
    }

    private static int simulation(int i, int j, int k) {
        int kill = 0;
        int curEnemy = enemy;  //현재 남아있는 적의 수
        copy = new int[N][M]; //복사본 생성
        for (int l = 0; l < N; l++) {
            for (int m = 0; m < M; m++) {
                copy[l][m] = grid[l][m];
            }
        }

        while(curEnemy > 0){
            pairs = new HashSet<>();
            findEnemy(i);
            findEnemy(j);
            findEnemy(k);
            for(Pair p : pairs){ //적 제거
                copy[p.x][p.y] = 0;
                kill++;
                curEnemy--;
            }
            for (int l = 0; l <M; l++) { //이동 시 캐슬에 도달하는 적들 고려
                if(copy[N-1][l] == 1){
                    curEnemy--;
                    copy[N-1][l] = 0;
                }
            }

            moveEnemy(); //남아있는 적을 한 칸씩 이동
        }
        return kill;
    }


    private static void moveEnemy() { //적 아래로 한칸 이동
        for (int i = N-1; i >= 1; i--) {
            for (int j = 0; j < M; j++) {
                if(copy[i-1][j] == 1){
                    copy[i][j] = 1;
                    copy[i-1][j] = 0;
                }
            }
        }
    }

    private static void findEnemy(int y){  //최소거리에 위치하는 적을 찾고 set에 넣어줌(중복 제거)
        int ax = N;
        int ay = y;
        int minDis = Integer.MAX_VALUE;
        int mx = -1;
        int my = -1;
        for(int i=N-D; i<=N-1; i++){
            if(i < 0) continue;      //궁수의 사거리가 격자 크기보다 클 경우 continue
            for(int j=0; j<M; j++){
                int dis = Math.abs(ax-i)+Math.abs(ay-j);
                if(copy[i][j] == 1 && dis <= D){ //적이면서 거리 안에 있는 경우
                    if(dis < minDis){            //거리가 더 작을 경우 최소거리 및 죽일 적 위치 갱신
                        minDis = dis;
                        mx = i;
                        my = j;
                    }else if(dis == minDis && j < my){  //최소 거리에 위치하면서 왼쪽에 있다면 적 위치 갱신
                        mx = i;
                        my = j;
                    }
                }
            }
        }
        if(mx != -1 && my != -1) pairs.add(new Pair(mx, my));
    }

}