package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_10026 {
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static int N;
	
	static char[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int count = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					DFS(i, j, map[i][j]);
					count++;
				}
			}
		} System.out.print(count + " ");

		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 'G')
					map[i][j] = 'R';
			}
		}
		
		count = 0;
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					DFS(i, j, map[i][j]);
					count++;
				}
			}
		} System.out.print(count);
	}
	
	public static void BFS(int x, int y, char c) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] loc = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = dx[i] + loc[0];
				int ny = dy[i] + loc[1];
				
				if(isCheck(nx, ny)) {
					if(map[nx][ny] == c && !visited[nx][ny]) {
						q.offer(new int[] {nx, ny});
						visited[nx][ny] = true;
					}
				}
			}
		}
	}
	
	public static void DFS(int x, int y, char c) {
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			
			if(isCheck(nx, ny)) {
				if(map[nx][ny] == c && !visited[nx][ny]) {
					DFS(nx, ny, c);
				}
			}
		}
	}
	
	public static boolean isCheck(int x, int y) {
		return x<N && y<N && x>=0 && y>=0;
	}
}
