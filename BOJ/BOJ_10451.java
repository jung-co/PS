package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_10451 {
	static LinkedList<Integer>[] list;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			
			list = new LinkedList[n+1];
			visited = new boolean[n+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				list[j] = new LinkedList<Integer>();
				
				int val = Integer.parseInt(st.nextToken());
				list[j].add(val);
			}
			
			int count = 0;
			for(int j=1; j<=n; j++) {
				if(!visited[j]) {
					DFS(j);
					count++;
				}
			}
			
			sb.append(count + "\n");
		}
		
		System.out.println(sb);
	}
	
	public static void DFS(int node) {
		if(!visited[node]) {
			visited[node] = true;
			for(int next : list[node]) {
				DFS(next);
			}
		}
	}
}
