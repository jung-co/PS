package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_1850 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		
		long gcd = GCD(a, b);
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<gcd; i++) {
			sb.append("1");
		}
		
		System.out.println(sb);
	}
	
	public static long GCD(long a, long b) {
		long max = Math.max(a, b);
		long min = Math.min(a, b);
		
		while(min != 0) {
			long tmp = max;
			max = min;
			min = tmp%min;
		}
		
		return max;
	}
}
