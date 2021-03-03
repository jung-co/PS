package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_5014 {
	static int f, s, g;
	static int[] ud = {1, -1};
	
	static int[] floor;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		f = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		ud[0] *= Integer.parseInt(st.nextToken());
		ud[1] *= Integer.parseInt(st.nextToken());
		
		floor = new int[f+1];
		visited = new boolean[f+1];
		
		int result = 0;
		if(s != g) result = BFS(s);
		
		if(result != -1) System.out.println(result);
		else System.out.println("use the stairs");
	}
	
	public static int BFS(int idx) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(idx);
		visited[idx] = true;
		
		while(!q.isEmpty()) {
			int loc = q.poll();
			
			for(int i=0; i<2; i++) {
				int d = loc + ud[i];
				
				if(d>0 && d<=f && !visited[d]) {
					floor[d] = floor[loc] + 1;
					if(d == g) {
						return floor[d];
					}
					
					visited[d] = true;
					q.offer(d);
				}
			}
		}
		
		return -1;
	}
}
