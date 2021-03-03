package BOJ;

import java.util.*;
import java.io.*;

class BOJ_2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        String str = st.nextToken();
        int b = Integer.parseInt(st.nextToken());
        
        int k = 0;
        long sum = 0;
        for(int i=str.length() - 1; i>=0; i--){
            int ch = str.charAt(i);
            
            if(ch>='A' && ch<='Z'){
                ch = ch - 'A' + 10;
            } else {
                ch = ch - '0';
            }
            
            sum += ch * Math.pow(b, k++);
        }
        
        System.out.println(sum);
    }
}