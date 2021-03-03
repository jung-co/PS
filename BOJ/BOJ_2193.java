package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_2193 {
	static int n;
	static long[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr = new long[n+1];
		System.out.println(DP(n));
	}
	
	public static long DP(int sz) {
		if(sz < 2) return sz;
		
		if(arr[sz] == 0) {
			arr[sz] = DP(sz-1) + DP(sz-2);
		}
		
		return arr[sz];
	}
}
