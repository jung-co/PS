package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 99;
        
        if(N<100) {
            System.out.println(N);
            return;
        }
        
        for(int i=100; i<=N; i++){
            String[] str = Integer.toString(i).split("");
            int t = -1;
            for(int j=1; j<str.length; j++){
                int a = Integer.parseInt(str[j-1]);
                int b = Integer.parseInt(str[j]);
                
                int tmp = Math.abs(a-b);
                if(t == -1)
                    t = tmp;
                else {
                    if(tmp != t) {
                        count--;
                        break;
                    }
                }
            } count++;
        }
        
        System.out.println(count);
    }
}