import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_점심식사시간 {
    static int T, N;
    static int[][] grid, arriveTime;
    static List<Pair> people;
    static List<Stair> stairs;
    static class Pair{
        int x, y, dis;

        public Pair(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
    static class Stair{
        int x, y, height;

        public Stair(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }
    static int minTime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            grid = new int[N][N];
            people = new ArrayList<>();
            stairs = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                    if(grid[i][j] == 1){  //사람일 경우 dis는 사용하지 않을 거므로 -1로 추가
                        people.add(new Pair(i, j, -1));
                    }
                    if(grid[i][j] != 1 && grid[i][j] != 0){ //계단 일 경우
                        stairs.add(new Stair(i, j, grid[i][j]));
                    }
                }
            }
            arriveTime = new int[stairs.size()][people.size()]; //각 사람들이 1, 2번 계단에 도착하는 시간 + 1(대기시간)을 저장
            for (int i = 0; i < stairs.size(); i++) {
                for (int j = 0; j < people.size(); j++) {
                    arriveTime[i][j] = Math.abs(people.get(j).x - stairs.get(i).x) + Math.abs(people.get(j).y - stairs.get(i).y) + 1; //대기 시간 고려
                }
            }

            minTime = Integer.MAX_VALUE;
            boolean[] visited = new boolean[people.size()];
            subSet(0, visited);
            sb.append("#").append(tc).append(" ").append(minTime).append("\n");
        }
        System.out.println(sb);
    }

    private static void subSet(int cnt, boolean[] visited){
        if (cnt == people.size()) {
            List<Integer> firstGroup = new ArrayList<>();
            List<Integer> secondGroup = new ArrayList<>();
            for (int i = 0; i < people.size(); i++) {
                if(visited[i]){
                    firstGroup.add(arriveTime[0][i]);
                }else{
                    secondGroup.add(arriveTime[1][i]);
                }
            }
            Collections.sort(firstGroup);
            Collections.sort(secondGroup);

            int firstStairEndTime = calTime(firstGroup, stairs.get(0).height);
            int secondStairEndTime = calTime(secondGroup, stairs.get(1).height);
            int temp = Math.max(firstStairEndTime, secondStairEndTime);
            minTime = Math.min(minTime, temp);
            return;
        }
        visited[cnt] = true;
        subSet(cnt + 1, visited);
        visited[cnt] = false;
        subSet(cnt + 1, visited);
    }

    private static int calTime(List<Integer> group, int height){
        if (group.size() == 0) {
            return 0;
        }
        if(group.size() <= 3){
            return group.get(group.size() - 1) + height;
        }
        int[] endTime = new int[group.size()];
        for (int i = 0; i < 3; i++) {
            endTime[i] = group.get(i) + height;
        }
        for (int i = 3; i < group.size(); i++) {
            int curArriveTime = group.get(i);
            if(curArriveTime < endTime[i-3]){
                endTime[i] = endTime[i - 3] + height;
            }else{
                endTime[i] = curArriveTime + height;
            }
        }
        return endTime[endTime.length-1];
    }
}