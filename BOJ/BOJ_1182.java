package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_1182 {
	static int n, s, count;
	
	static int[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		visited = new boolean[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		count = 0;
		back(0, 0);
		if(s==0) count-=1;
		System.out.println(count);
	}
	
	public static void back(int idx, int val) {
		if(val == s) count++;
		
		for(int i=idx; i<n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				back(i, arr[i]+val);
				visited[i] = false;
			}
		}
	}
}
