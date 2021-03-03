package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_11726 {
	static int[] list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		list = new int[n+1];
		int tmp = DP(n);
		
		System.out.println(tmp);
	}
	
	public static int DP(int idx) {
		if(idx < 2) return 1;
		
		if(list[idx] == 0) {
			list[idx] = DP(idx - 1) + DP(idx - 2);
		} 
		
		list[idx] %= 10007;
		return list[idx];
	}
}
