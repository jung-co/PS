package BOJ;

import java.util.*;
import java.io.*;

class BOJ_1373 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        StringBuilder sb = new StringBuilder();
        int result = 0;
        int count = -1;
        for(int i=str.length()-1; i>=0; i--) {
        	int tmp = str.charAt(i) - '0';
        	count++;
        	
        	if(count <= 2) {
        		result += tmp * Math.pow(2, count);
        		if(count == 2) {
        			sb.append(result);
        			count = -1;
        			result = 0;
        		} else if(i == 0) {
        			sb.append(result);
        		}
        	}
        }
        
        str = sb.toString();
        sb = new StringBuilder();
        for(int i=str.length()-1; i>=0; i--) {
        	sb.append(str.charAt(i));
        }
        
        System.out.println(sb);
    }
}