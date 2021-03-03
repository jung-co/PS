package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_10971 {
	static int n;
	static int start;
	static int ans;
	
	static int[][] map;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		map = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[n+1];
		ans = Integer.MAX_VALUE;
		search(0, 0, 0);
		
		System.out.println(ans);
	}
	
	public static void search(int idx, int len, int sum) {
		if(len == n) {
			if(map[idx][start] != 0)
				ans = Math.min(ans, sum + map[idx][start]);
			return;
		}
		
		for(int i=1; i<=n; i++) {
			if(!visited[i]) {
				if(idx == 0) start = i;
				if(idx == 0 || map[idx][i] != 0) {
					visited[i] = true;
					search(i, len+1, sum + map[idx][i]);
					visited[i] = false;
				}
			}
		}
	}
}
