package BOJ;

import java.util.*;
import java.io.*;

class BOJ_9613 {
    static int[] list;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            list = new int[Integer.parseInt(st.nextToken())];
            
            for(int j=0; j<list.length; j++) {
            	list[j] = Integer.parseInt(st.nextToken());
            }
            
            sb.append(GCD(list.length) + "\n");
        }
        
        System.out.println(sb);
    }
    
    public static long GCD(int len){
        
    	long sum = 0;
    	for(int i=0; i<len-1; i++){
            for(int j=i+1; j<len; j++){
                int max = Math.max(list[i], list[j]);
                int min = Math.min(list[i], list[j]);
                
                while(min > 0){
                    int tmp = max;
                    max = min;
                    min = tmp % min;
                }
                
                sum += max;
            }
        }

    	return sum;
    }
}