package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_1699 {
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		dp = new int[n+1];
		dp[1] = 1;
		
		System.out.println(DP(n));
	}
	
	public static int DP(int n) {
		if(dp[n] > 0 || n == 1) return dp[n];
		
		dp[n] = n;
		for(int i=1; i*i <= n; i++) {
			dp[n] = Math.min(DP(n-(i*i)) + 1, dp[n]);
		}
		
		return dp[n];
	}
}
