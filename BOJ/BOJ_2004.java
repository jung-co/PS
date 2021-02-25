package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_2004 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long n = Integer.parseInt(st.nextToken());
		long m = Integer.parseInt(st.nextToken());
		
		long five = FIVE(n) - FIVE(n-m) - FIVE(m);
		long two = TWO(n) - TWO(n-m) - TWO(m);
		
		System.out.println(Math.min(five, two));
	}
	
	public static long FIVE(long num) {
		int cnt = 0;
		
		while(num >= 5) {
			cnt += num / 5;
			num /= 5;
		}
		
		return cnt;
	}
	
	public static long TWO(long num) {
		int cnt = 0;
		
		while(num >= 2) {
			cnt += num / 2;
			num /= 2;
		}
		
		return cnt;
	}
}
