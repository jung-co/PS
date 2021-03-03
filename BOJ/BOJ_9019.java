package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_9019 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int t=0; t<n; t++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			boolean[] visited = new boolean[10000];
			String[] command = new String[10000];
			Arrays.fill(command, "");
			
			Queue<Integer> q = new LinkedList<>();
			visited[a] = true;
			q.add(a);
			
			while(!q.isEmpty() && !visited[b]) {
				int loc = q.poll();
				
				int d = (2*loc) % 10000;
				int s = (loc == 0) ? 9999 : loc-1;
				int l = (loc % 1000) * 10 + loc/1000;
				int r = (loc % 10) * 1000 + loc/10;
				
				//sb.append(l + " " + r + "\n");
				if(!visited[d]) {
					q.add(d);
					visited[d] = true;
					command[d] = command[loc] + "D";
				}
				
				if(!visited[s]) {
					q.add(s);
					visited[s] = true;
					command[s] = command[loc] + "S";
				}
				
				if(!visited[l]) {
					q.add(l);
					visited[l] = true;
					command[l] = command[loc] + "L";
				}
				
				if(!visited[r]) {
					q.add(r);
					visited[r] = true;
					command[r] = command[loc] + "R";
				}
			}
			
			System.out.println(sb + command[b]);
		}
	}
}
