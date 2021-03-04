package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_3108 {
	static int n;
	static Rec[] map;
	static boolean[] visited;
	
	private static class Rec {
		int x1, y1;
		int x2, y2;
		
		Rec(int x1, int y1, int x2, int y2){
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		boolean flag = false;
		map = new Rec[n+1];
		visited = new boolean[n+1];
		map[0] = new Rec(0, 0, 0, 0);
		
		StringTokenizer st;
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			map[i] = new Rec(x1, y1, x2, y2);
		}
		
		int cnt = 0;
		for(int i=0; i<=n; i++) {
			if(!visited[i]) {
				BFS(i);
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
	private static void BFS(int i) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(i);
		visited[i] = true;
		
		while(!q.isEmpty()) {
			int loc = q.poll();
			
			for(int j=0; j<=n; j++) {
				if(loc==j || check(loc, j) || visited[j]) {
					continue;
				}
				
				visited[j] = true;
				q.add(j);
			}
		}
	}
	
	private static boolean check(int loc, int next) {
		Rec l = map[loc];
		Rec n = map[next];
		
		return (l.x2<n.x1 || l.x1>n.x2 || l.y1>n.y2 || l.y2<n.y1)
				|| (l.x1<n.x1 && l.x2>n.x2 && l.y1<n.y1 && l.y2>n.y2)
				|| (n.x1<l.x1 && n.x2>l.x2 && n.y1<l.y1 && n.y2>l.y2);
	}
}
