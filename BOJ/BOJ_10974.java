package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_10974 {
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		boolean[] visited = new boolean[n+1];
		for(int i=1; i<=n; i++) {
            int[] arr = new int[n+1];
		
			visited[i] = true;
			DFS(arr, 1, i, visited);
			visited[i] = false;
		}
	}
	
	public static void DFS(int[] arr, int size, int node, boolean[] visited) {
		arr[size] = node;
		
		if(size >= n) {
			for(int i=1; i<=size; i++) {
				System.out.print(arr[i] + " ");
			} System.out.println();
			
			return;
		}
		
		for(int i=1; i<=n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				DFS(arr, size+1, i, visited);
				visited[i] = false;
			}
		}
	}
}
