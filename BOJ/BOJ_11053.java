package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_11053 {
	static int n;
	
	static int[] arr;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		dp = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<n; i++) {
			DP(i);
		}
		
		int max = dp[0];
		for(int i=1; i<n; i++) {
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}
	
	public static int DP(int idx) {
		if(dp[idx] == 0) {
			dp[idx] = 1;
			for(int i=idx-1; i>=0; i--) {
				if(arr[i] < arr[idx]) {
					dp[idx] = Math.max(dp[idx], DP(i) + 1);
				}
			}
		}
		
		return dp[idx];
	}
}
