package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_1167 {
	static int n;
	
	static LinkedList<Edge>[] map;
	static boolean[] visited;
	static int[] list;
	
	public static class Edge {
		int idx;
		int val;
		
		public Edge(int idx, int val) {
			this.idx = idx;
			this.val = val;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		map = new LinkedList[n+1];
		for(int i=1; i<=n; i++) {
			map[i] = new LinkedList<>();
		}
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			
			while(true) {
				int v = Integer.parseInt(st.nextToken());
				if(v == -1) break;
				
				int e = Integer.parseInt(st.nextToken());
				map[num].add(new Edge(v, e));
			}
		}
		
		int[] dist = BFS(1);
		int start = 1;
		for(int i=2; i<=n; i++) {
			if(dist[i] > dist[start])
				start = i;
		}
		
		dist = BFS(start);
		int ans = dist[1];
		for(int i=2; i<=n; i++) {
			if(ans < dist[i]) {
				ans = dist[i];
			}
		}
		
		System.out.println(ans);
	}
	
	static int[] BFS(int node) {
		Queue<Integer> q = new LinkedList<>();
		visited = new boolean[n+1];
		
		q.offer(node);
		visited[node] = true;
		
		int[] dist = new int[n+1];
		while(!q.isEmpty()) {
			int loc = q.poll();
			
			Iterator<Edge> iter = map[loc].iterator();
			while(iter.hasNext()) {
				Edge next = iter.next();
				 
				if(!visited[next.idx]) {
					dist[next.idx]= dist[loc] + next.val;
					q.offer(next.idx);
					visited[next.idx] = true;
				}
			}
		}
		
		return dist;
	}
}