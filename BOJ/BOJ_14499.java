package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_14499 {
    public static class Dice {
        int top, bottom, left, right, front, back;

        public Dice(){
            top = 0;
            bottom = 0;
            left = 0;
            right = 0;
            front = 0;
            back = 0;
        }

        public void North(){
            int tmp = top;
            top = front;
            front = bottom;
            bottom = back;
            back = tmp;
        }

        public void South(){
            int tmp = top;
            top = back;
            back = bottom;
            bottom = front;
            front = tmp;
        }

        public void West(){
            int tmp = top;
            top = right;
            right = bottom;
            bottom = left;
            left = tmp;
        }

        public void East(){
            int tmp = top;
            top = left;
            left = bottom;
            bottom = right;
            right = tmp;
        }

        public void print(){
            System.out.println(top);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dir = new int[k];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++){
            dir[i] = Integer.parseInt(st.nextToken());
        }

        int[] di = {0, 0, -1, 1};
        int[] dj = {1, -1, 0, 0};

        int[] now = { x, y };
        Dice dice = new Dice();
        for(int i=0; i<k; i++){
            int nx = now[0]+di[dir[i]-1];
            int ny = now[1]+dj[dir[i]-1];

            if(!check(n, m, nx, ny)){
                continue;
            }

            switch(dir[i]){
                case 1:
                    dice.East();
                    break;
                case 2:
                    dice.West();
                    break;
                case 3:
                    dice.North();
                    break;
                case 4:
                    dice.South();
                    break;
            }

            if(map[nx][ny] == 0){
                map[nx][ny] = dice.bottom;
            } else {
                dice.bottom = map[nx][ny];
                map[nx][ny] = 0;
            }

            dice.print();
            now[0] = nx;
            now[1] = ny;
        }
    }

    public static boolean check(int n, int m, int x, int y){
        if(x>=n || y>=m || x<0 || y<0){
            return false;
        }
        return true;
    }
}