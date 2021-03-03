package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_1963 {
	static boolean[] prime;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		prime = new boolean[10000];
		prime[1] = true;
		for(int i=2; i<=Math.sqrt(9999); i++) {
			for(int j=i+i; j<10000; j+=i) {
				prime[j] = true;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(x == y) sb.append(0);
			else sb.append(BFS(x, y));
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static int BFS(int n, int m) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[100000];
		
		q.offer(n);
		visited[n] = true;
		
		int cnt = -1;
		while(!q.isEmpty()) {
			cnt++;
			
			int size = q.size();
			for(int i=0; i<size; i++) {
				int loc = q.poll();
				
				if(loc == m) {
					return cnt;
				}
				
				char[] tmp = Integer.toString(loc).toCharArray();
				int[] num = new int[4];
				for(int j=0; j<4; j++) {
					num[j] = tmp[j] - '0';
				}
				
				for(int j=0; j<4; j++) {
					for(int k=0; k<10; k++) {
						num[j] = num[j]+1 > 9 ? 0 : num[j]+1;
						
						int next = 0;
						for(int l=0; l<4; l++) {
							next += num[l] * Math.pow(10, 3-l);
						}
						
						if(next < 1000) continue;
						if(visited[next]) continue;
						if(prime[next]) continue;
						
						q.add(next);
						visited[next] = true;
					}
				}
			}
		}
		
		return -1;
	}
}
