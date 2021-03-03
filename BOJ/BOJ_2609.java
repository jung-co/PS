package BOJ;

import java.util.*;
import java.io.*;

class BOJ_2609 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        
        StringBuilder sb = new StringBuilder();
        long ans = GCD(a, b);
        
        System.out.println(ans);
        System.out.println(a*b/ans);
    }
    
    public static long GCD(long a, long b) {
    	long max = Math.max(a, b);
    	long min = Math.min(a, b);
    	
    	while(min > 0) {
			long tmp = max;
			max = min;
			min = tmp % min;
    	}
    	
    	return max;
    }
}