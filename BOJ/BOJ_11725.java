package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_11725 {
	static int N;
	static LinkedList<Integer>[] list;
	static boolean[] visited;
	
	static int[] result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		list = new LinkedList[N+1];
		visited = new boolean[N+1];
		result = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			list[i] = new LinkedList<>();
		}
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		} BFS(1);
		
		for(int i=2; i<=N; i++) {
			System.out.println(result[i]);
		}
	}
	
	public static void BFS(int node) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(node);
		visited[node] = true;
		
		while(!q.isEmpty()) {
			int loc = q.poll();
			
			Iterator<Integer> iter = list[loc].iterator();
			while(iter.hasNext()) {
				int next = iter.next();
				
				if(!visited[next]) {
					result[next] = loc;
					
					q.offer(next);
					visited[next] = true;
				}
			}
		}
	}
}
