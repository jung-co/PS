package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_15652 {
	static int n, m;
	
	static int[] arr;
	static boolean[] visited;
	

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[1] = i;
			DFS(i, 1);
		}
		
		System.out.println(sb);
	}
	
	public static void DFS(int node, int size) {
		if(size == m) {
			for(int i=1; i<=size; i++) {
				sb.append(arr[i] + " ");
			} sb.append("\n");
			
			return;
		}
		
		for(int i=node; i<=n; i++) {
			arr[size+1] = i;
			DFS(i, size+1);
		}
	}
}
