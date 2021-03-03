package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_2156 {
	static int n;
	
	static int[] arr;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n+1];
		dp = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		} Arrays.fill(dp, -1);
		
		dp[0] = 0;
		dp[1] = arr[1];
		if(n>1) dp[2] = arr[1] + arr[2];
		
		System.out.println(DP(n));
	}
	
	public static int DP(int idx) {
		
		if(dp[idx] == -1) {
			dp[idx] = Math.max(Math.max(DP(idx-2), DP(idx-3) + arr[idx-1]) + arr[idx], DP(idx-1));
		}
		
		return dp[idx];
	}
}
