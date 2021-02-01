package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_10844 {
	static int n;
	static long[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new long[n+1][10];
		Arrays.fill(arr[1], 1);
		
		long result = 0;
		for(int i=1; i<=9; i++) {
			result += DP(n, i);
		}
		
		System.out.println(result % 1000000000);
	}
	
	public static long DP(int idx, int val) {
		if(idx == 1) return arr[idx][val];
		
		if(arr[idx][val] == 0) {
			if(val == 0)
				arr[idx][val] = DP(idx-1, 1);
			else if(val==9)
				arr[idx][val] = DP(idx-1, 8);
			else
				arr[idx][val] = DP(idx-1, val-1) + DP(idx-1, val+1);
		}
		
		return arr[idx][val];
	/*	if(val < 3) return arr[val];
		
		if(arr[val] == 0) {
			arr[val] = (DP(val-1) * 2 - 2);
		}
		
		return arr[val]%1000000000;
	*/
	}
}