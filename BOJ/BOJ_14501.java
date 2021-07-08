package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] t = new int[n+2];
		int[] p = new int[n+2];
		int[] dp = new int[n+2];

		StringTokenizer st;
		for(int i=1; i<=n; i++){
			st = new StringTokenizer(br.readLine());

			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}

		for(int i=n; i>0; i--){
			int day = i + t[i];

			if(day<=n+1){
				dp[i] = Math.max(p[i]+dp[day], dp[i+1]);
			} else {
				dp[i] = dp[i+1];
			}
		}

		System.out.println(dp[1]);
	}
}
