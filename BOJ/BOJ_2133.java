package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_2133 {
	static long[] dp;
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		dp = new long[n+1];
		dp[0] = 1;
		if(n>1) dp[2] = 3;
		
		
		System.out.println(DP(n));
	}
	
	public static long DP(int idx) {
		if(idx % 2 == 1) return dp[idx];
		
		if(dp[idx] == 0) {
			for(int i=2; i<=idx; i+=2) {
				int tmp = i == 2 ? 3 : 2;
				dp[idx] += tmp * DP(idx - i);
			}
		}
		
		return dp[idx];
	}
}
