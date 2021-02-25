package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_10819 {
	static int n;
	static int max = 0;
	
	static int[] arr;
	static int[] ans;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		ans = new int[n];
		visited = new boolean[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		m(0);
		System.out.println(max);
	}
	
	public static void m(int len) {
		if(len == n) {
			int sum = 0;
			for(int i=0; i<len-1; i++) {
				sum += Math.abs(ans[i] - ans[i+1]);
			}
			
			if(max < sum) max = sum;
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				ans[len] = arr[i];
				m(len+1);
				visited[i] = false;
			}
		}
	}
}
