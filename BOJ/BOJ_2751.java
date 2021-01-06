package BOJ;

import java.util.*;
import java.io.*;

class BOJ_2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        
        ArrayList<Integer> num = new ArrayList<>();
        for(int i=0; i<n; i++){
            num.add(Integer.parseInt(br.readLine()));
        }
        
        Collections.sort(num);
        
        for(int val : num) {
        	sb.append(val).append('\n');
        }
        
        

        System.out.println("\u250C\u252C\u2510");
        System.out.println("\u251C\u253C\u2524");
        System.out.println("\u2514\u2534\u2518");
        System.out.println(sb);
    }
}