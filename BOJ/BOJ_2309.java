package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> height = new ArrayList<>();
        
        int sum = 0;
        for(int i=0; i<9; i++){
            int tmp = Integer.parseInt(br.readLine());
            height.add(tmp);
            sum += tmp;
        }
        
        for(int i=0; i<8; i++){
            for(int j=i+1; j<9; j++){
                int tmp = sum - height.get(i) - height.get(j);
                if(tmp == 100){
                    height.remove(i);
                    height.remove(j-1);
                    
                    Collections.sort(height);
                    for(int k=0; k<7; k++){
                        System.out.println(height.get(k));
                    } return;
                }
            }
        }
    }
}