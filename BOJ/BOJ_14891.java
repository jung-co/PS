package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14891 {
    static int[][] gear;
    static int n, l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        gear = new int[4][8];
        for(int i=0; i<4; i++){
            String str = br.readLine();
            for(int j=0; j<8; j++){
                gear[i][j] = str.charAt(j) - '0';
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());

        int[][] direction = new int[r][2];
        for(int i=0; i<r; i++){
            st = new StringTokenizer(br.readLine());

            direction[i][0] = Integer.parseInt(st.nextToken());
            direction[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<r; i++){
            int gear_num = direction[i][0] - 1;
            int dir = direction[i][1];

            boolean[] diff = new boolean[3];
            for(int j=0; j<3; j++){
                if(gear[j][2] == gear[j+1][6]){
                    diff[j] = true;
                } else {
                    diff[j] = false;
                }
            }

            rotation(gear_num, dir);
            if(gear_num == 0){
                for(int j=0; j<3; j++){
                    if(!diff[j]){
                        dir *= -1;
                        rotation(j+1, dir);
                    } else {
                        break;
                    }
                }
            } else if(gear_num == 3){
                for(int j=2; j>=0; j--){
                    if(!diff[j]){
                        dir *= -1;
                        rotation(j, dir);
                    } else {
                        break;
                    }
                }
            } else {
                for(int j=gear_num-1; j>=0; j--){
                    if(!diff[j]){
                        dir *= -1;
                        rotation(j, dir);
                    } else
                        break;
                }

                for(int j=gear_num; j<3; j++){
                    if(!diff[j]){
                        dir *= -1;
                        rotation(j+1, dir);
                    } else
                        break;
                }
            }
        }

        int sum = 0;
        for(int i=0; i<4; i++){
            if(gear[i][0] != 0){
                sum += (int)Math.pow(2, i);
            }
        }

        System.out.println(sum);
    }

    public static void rotation(int gear_num, int dir){
        if(dir==1){
            int top = gear[gear_num][7];
            for(int i=7; i>0; i--){
                gear[gear_num][i] = gear[gear_num][i-1];
            }
            gear[gear_num][0] = top;
        } else {
            int top = gear[gear_num][0];
            for(int i=0; i<7; i++){
                gear[gear_num][i] = gear[gear_num][i+1];
            }
            gear[gear_num][7] = top;
        }
    }
}
