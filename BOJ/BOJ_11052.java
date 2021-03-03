package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_11052 {
	static int n;
	static int[] dp;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		dp = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=i; j++) {
				dp[i] = Math.max(dp[i-j] + arr[j], dp[i])
						;
			}
		}
		
		System.out.println(dp[n]);
	}
}
