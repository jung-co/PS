package BOJ;

import java.util.*;
import java.io.*;

class BOJ_2875 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int max = Math.min(n/2, m);
        while(true) {
        	int xn = n - max*2;
        	int xm = m - max;
        	
        	if(xn+xm < k) max--;
        	else break;
        }
        
        System.out.println(max);
    }
}