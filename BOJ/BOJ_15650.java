package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_15650 {
	static int n, m;
	
	static int[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1];
		for(int i=1; i<=n; i++) {
			visited = new boolean[n+1];
			visited[i] = true;
			arr[1] = i;
			
			DFS(i, 1);
		}
	}
	
	public static void DFS(int node, int size) {
		if(size == m) {
			for(int i=1; i<=size; i++) {
				System.out.print(arr[i] + " ");
			} System.out.println();
			
			return;
		}
		
		for(int i=node+1; i<=n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[size+1] = i;
				
				DFS(i, size+1);
				visited[i] = false;
			}
		}
	}
}
