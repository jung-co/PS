package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_11727 {
	static int[] list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		list = new int[n+1];
		int tmp = DP(n);
		
		System.out.println(tmp);
	}
	
	public static int DP(int idx) {
		if(idx == 1) return 1;
		else if(idx == 2) return 3;
		
		if(list[idx] == 0) {
			list[idx] = DP(idx - 1) + DP(idx - 2) * 2;
		} 
		
		list[idx] %= 10007;
		return list[idx];
	}
}
