package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_1806 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		long s = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = Integer.MAX_VALUE;
		int first = 0;
		int second = 0;
		int sum = 0;
		while(second != n) {
			if(sum >= s) {
				sum -= arr[first++];
				ans = Math.min(ans, (second - first) + 1);
			} else {
				sum += arr[second++];
			}
		}
		
		if(ans == Integer.MAX_VALUE)
			System.out.println(0);
		else System.out.println(ans);
		
	}
}
