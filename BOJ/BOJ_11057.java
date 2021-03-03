package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_11057 {
	static long[][] arr;
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		arr = new long[n+1][10];
		long sum = 0;
		for(int i=0; i<10; i++) {
			sum+=DP(n, i);
		}
		
		System.out.println(sum%10007);
	}
	
	public static long DP(int idx, int val) {
		if(idx == 1) return 1;
		if(arr[idx][val] > 0) return arr[idx][val];
		
		for(int i=0; i<10; i++) {
			for(int j=0; j<=i; j++) {
				arr[idx][i] += DP(idx-1, j);
				arr[idx][i] %= 10007;
			}
		}
		
		return arr[idx][val];
	}
}
