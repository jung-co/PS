package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_1167 {
	static int n;
	
	static int[][] map;
	static boolean[] visited;
	static int[] list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			
			while(true) {
				int v = Integer.parseInt(st.nextToken());
				if(v == -1) break;
				
				int e = Integer.parseInt(st.nextToken());
				
				map[num][v] = e;
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=1; i<=n; i++) {
			visited = new boolean[n+1];
			list = new int[n+1];
			
			BFS(i);
			
			for(int j=1; j<=n; j++) {
				if(max < list[j]) {
					max = list[j];
				}
			}
		}
		
		System.out.println(max);
	}
	
	static void BFS(int node) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(node);
		visited[node] = true;
		
		while(!q.isEmpty()) {
			int loc = q.poll();
			
			for(int i=1; i<=n; i++) {
				if(!visited[i] && map[loc][i]!=0) {
					q.offer(i);
					visited[i] = true;
					list[i] = map[loc][i] + list[loc];
				}
			}
		}
	}
}
