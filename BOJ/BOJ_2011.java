package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_2011 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine();
		int len = num.length();
		
		long[][] dp = new long[len+1][2];
		dp[0][0] = dp[1][0] = 1;
		
		if(num.charAt(0)-'0' == 0) {
			System.out.println(0);
			return;
		}
		
		for(int i=2; i<=len; i++) {
			int tmp2 = num.charAt(i-2) - '0';
			int tmp1 = num.charAt(i-1) - '0';
			
			if(tmp1 == 0) {
				if(tmp2 == 0) {
					System.out.println(0);
					return;
				} else dp[i][0] = 0;
			} else
				dp[i][0] = (dp[i-1][0] + dp[i-1][1]) % 1000000;
		
			if(tmp2 == 1) {
				if(tmp1 >= 0 && tmp1 < 10)
					dp[i][1] = (dp[i-2][0] + dp[i-2][1]) % 1000000;
			} else if(tmp2 == 2) {
				if(tmp1 >= 0 && tmp1 < 7)
					dp[i][1] = (dp[i-2][0] + dp[i-2][1]) % 1000000;
			} else dp[i][1] = 0;
		}
		
		long sum = dp[len][0] + dp[len][1];
		System.out.println(sum % 1000000);
	}
}
