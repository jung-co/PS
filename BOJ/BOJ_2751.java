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
        } System.out.println(sb);
    }
}