package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_3190 {
    static int[] di = {0, 0, -1, 1};
    static int[] dj = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); // 보드 개수
        int k = Integer.parseInt(br.readLine()); // 사과의 개수

        int[][] map = new int[n][n];
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x-1][y-1] = 1;
        }

        int l = Integer.parseInt(br.readLine());
        LinkedList<int[]> cmd = new LinkedList<>(); // 이동하는 초와 방향
        for(int i=0; i<l; i++){
            st = new StringTokenizer(br.readLine());

            int d = Integer.parseInt(st.nextToken());
            int s = st.nextToken().equals("L") ? -1 : 1;

            cmd.add(new int[] { d, s });
        }

        int time = 0;
        int dir = 1;
        LinkedList<int[]> snake = new LinkedList<>();
        snake.add(new int[] { 0, 0 });
        while(true) {
            time++;
            int[] head = snake.getLast();
            int[] tail = snake.getFirst();

            int ni = head[0] + di[dir];
            int nj = head[1] + dj[dir];

            if(ni<0 || nj<0 || ni>=n || nj>=n){
                break;
            }

            if(map[ni][nj] == 0){
                snake.add(new int[] {ni, nj});
                map[ni][nj] = 2;
                map[tail[0]][tail[1]] = 0;
                snake.remove(0);
            } else if (map[ni][nj] == 1){
                snake.add(new int[] {ni, nj});
                map[ni][nj] = 2;
            } else {
                break;
            }

            if(!cmd.isEmpty() && time == cmd.getFirst()[0]){
                if(cmd.getFirst()[1] == 1){
                    if(dir == 3){
                        dir = 0;
                    } else {
                        dir++;
                    }
                } else {
                    if(dir == 0){
                        dir = 3;
                    } else {
                        dir--;
                    }
                }
                cmd.remove(0);
            }
        }

        System.out.println(time);
    }
}
