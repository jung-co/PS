package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_2579 {
	static int n;
	
	static int[] floor;
	static int[] dp;
	
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		floor = new int[n+1];
		dp = new int[n+1];
		for(int i=1; i<=n; i++) {
			floor[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = floor[1];
		if(n > 1) dp[2] = floor[1] + floor[2];
		
		for(int i=3; i<=n; i++) {
			dp[i] = Math.max(dp[i-2], dp[i-3] + floor[i-1]) + floor[i];
		}
		
		System.out.println(dp[n]);
	}
}
