package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_11722 {
	static int n;
	
	static int[] num;
	static int[] cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		num = new int[n];
		cnt = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		for(int i=0; i<n; i++) {
			max = Math.max(max, DP(i));
		}
		
		System.out.println(max);
	}
	
	public static int DP(int idx) {
		if(cnt[idx] > 0) return cnt[idx];
		
		cnt[idx] = 1;
		for(int i=idx-1; i>=0; i--) {
			if(num[i] > num[idx]) {
				cnt[idx] = Math.max(cnt[idx], DP(i) + 1);
			}
		}
		
		return cnt[idx];
	}
}
