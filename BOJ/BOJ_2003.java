package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_2003 {
	static int n, sum;
	static int[] arr;
	static boolean[] visited;
	
	static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		sum = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		visited = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<n; i++) {
			visited[i] = true;
			DFS(i, arr[i]);
			visited[i] = false;
		}
		
		System.out.println(count);
	}
	
	public static void DFS(int idx, int val) {
		if(val == sum) count++;
		if(idx == n-1) {
			return;
		}
		
		DFS(idx+1, val+arr[idx+1]);
	}
}
