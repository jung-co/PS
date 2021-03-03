package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_2225 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		long[][] dp = new long[k+1][n+1];
		for(int i=1; i<=k; i++) {
			dp[i][0] = 1;
		}
		
		for(int i=1; i<=k; i++) {
			for(int j=1; j<=n; j++) {
				dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 1000000000;
			}
		}
		
		System.out.println(dp[k][n]);
	}
}
