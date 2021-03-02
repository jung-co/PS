package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_2146 {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int n, cnt;
	static int[][] map;
	static int[][] group;
	static boolean[][] visited;
	
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		group = new int[n][n];
		visited = new boolean[n][n];
		
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cnt = 1;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					Group(i, j); // ¼¶µé Ç¥½Ã
					cnt++;
				}
			}
		}
		
		for(int i=1; i<=cnt; i++) {
			int tmp = bridge(i);
			min = Math.min(min, tmp);
		}
		System.out.println(min); 
	}
	
	public static void Group(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		group[x][y] = cnt;
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] loc = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = loc[0] + dx[i];
				int ny = loc[1] + dy[i];
				
				if(nx>=0 && nx<n && ny>=0 && ny<n) {
					if(!visited[nx][ny]) {
						if(map[nx][ny] == 1) {
							group[nx][ny] = cnt;
							q.offer(new int[] {nx, ny});
							visited[nx][ny] = true;
						}
					}
				}
			}
		}
	}
	
	public static int bridge(int idx) {
		Queue<int[]> q = new LinkedList<>();
		visited = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(group[i][j] == idx) {
					visited[i][j] = true;
					q.add(new int[] {i, j, 0});
				}
			}
		}
		
		while(!q.isEmpty()) {
			int[] loc = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = loc[0] + dx[i];
				int ny = loc[1] + dy[i];
				
				if(nx>=0 && nx<n && ny>=0 && ny<n) {
					if(!visited[nx][ny]) {
						visited[nx][ny] = true;
						if(group[nx][ny] == 0)
							q.add(new int[] {nx, ny, loc[2] + 1});
						else
							return loc[2];
					}
				}
			}
		}
		
		return Integer.MAX_VALUE;
	}
}
