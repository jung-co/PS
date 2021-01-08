package SWEA;

import java.util.*;
import java.io.*;

public class SWEA_1979 {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int n, k;
	
	static char[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int test_case = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=test_case; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			map = new char[n][n];
			visited = new boolean[n][n];
			for(int i=0; i<n; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(!visited[i][j] && map[i][j] == '1') {
						
					}
				}
			}
			
			// System.out.format("#%d %d\n", t, k_num);
		}
	}
	
	public static int DFS(int x, int y, int dir_idx, int count) {
		visited[x][y] = true;
		if(count > k) return -1;
		
		int nx = x + dx[dir_idx];
		int ny = y + dy[dir_idx];
		
		int sum = count;
		if(nx>=0 && ny>=0 && nx<n && ny<n) {
			if(map[nx][ny] == '1'){
				sum = DFS(nx, ny, dir_idx, count+1);
			}
		}
		
		return sum;
	}
}