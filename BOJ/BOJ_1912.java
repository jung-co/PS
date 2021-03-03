package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_1912 {
	static int[] list;
	static long[] sum;
	
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		list = new int[n+1];
		sum = new long[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		sum[0] = list[0];
		long max = 0;
		for(int i=1; i<n; i++) {
			sum[i] = Math.max(sum[i-1] + list[i], list[i]);
			max = Math.max(max, sum[i]);
		}
		
		System.out.println(max);
	}
}
