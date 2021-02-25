package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_9461 {
	static int n;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			n = Integer.parseInt(br.readLine());
			dp = new int[n+1];
			
			dp[1] = 1;
			if(n>1) dp[2] = 1;
			sb.append(DP(n) + "\n");
		}
		
		System.out.println(sb);
	}
	
	public static int DP(int idx) {
		if(idx<3) return dp[idx];
		
		if(dp[idx] == 0) {
			dp[idx] = DP(idx-2) + DP(idx-3);
		}
		
		return dp[idx];
	}
}
