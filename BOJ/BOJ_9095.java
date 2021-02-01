package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_9095 {
	static int n;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n+1];
			
			arr[1] = 1;
			if(n>1) {
				arr[2] = 2;
				if(n>2) arr[3] = 4;
			} sb.append(DP(n)+"\n");
		}
		
		System.out.println(sb);
	}
	
	public static int DP(int val) {
		if(val <= 3) return arr[val];
		
		if(arr[val] == 0) {
			arr[val] = DP(val-1) + DP(val-2) + DP(val-3);
		}
		
		return arr[val];
	}
}
