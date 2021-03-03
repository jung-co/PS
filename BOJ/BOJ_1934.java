package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_1934 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int lcd = a*b/GCD(a, b);
			sb.append(lcd + "\n");
		}
		
		System.out.println(sb);
	}
	
	public static int GCD(int a, int b) {
		int max = Math.max(a, b);
		int min = Math.min(a, b);
		
		while(min != 0) {
			int tmp = max;
			max = min;
			min = tmp%min;
		}
		
		return max;
	}
}
