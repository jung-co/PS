package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_9466 {
	public static int[] arr;
	static boolean[] visited;
	static boolean[] team;
	
	static int cnt;
	static boolean flag;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			
			cnt = 0;
			arr = new int[n+1];
			team = new boolean[n+1];
			visited = new boolean[n+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			for(int j=1; j<=n; j++) {
				if(!team[j])
					DFS(j);
			}
			
			sb.append((n-cnt) + "\n");
		}
		
		System.out.println(sb);
	}
	
	static void DFS(int n) {
		if(visited[n]) {
			team[n] = true; cnt++;
		} else visited[n] = true;
		
		if(!team[arr[n]]) DFS(arr[n]);
		visited[n] = false;
		team[n] = true;
	}
}
