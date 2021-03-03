package BOJ;

import java.util.*;
import java.io.*;

class BOJ_1212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        if(str.equals("0")) {
        	System.out.println(0);
        	return;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++) {
        	int num = str.charAt(i) - '0';
        	
        	String s = "";
        	for(int j=0; j<3; j++) {
        		int rem = num % 2;
        		num /= 2;
        		s = rem + s;
        	}
        	
        	if(i==0) {
        		int tmp = Integer.parseInt(s);
        		s = Integer.toString(tmp);
        	}
        	
        	sb.append(s);
        }
        
        System.out.println(sb);
    }
}