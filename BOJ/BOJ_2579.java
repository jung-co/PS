package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_2579 {
	static int n;
	
	static int[] floor;
	static Integer[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		floor = new int[n+1];
		dp = new Integer[n+1];
		for(int i=1; i<=n; i++) {
			floor[i] = Integer.parseInt(br.readLine());
		}
		
        dp[0] = floor[0];
		dp[1] = floor[1];
		if(n>1) dp[2] = floor[1] + floor[2];
		
		System.out.println(DP(n));
	}
	
	public static int DP(int idx) {
		if(dp[idx] == null) {
			dp[idx] = Math.max(DP(idx-2), DP(idx-3) + floor[idx-1]) + floor[idx];
		}
		
		return dp[idx];
	}
}
