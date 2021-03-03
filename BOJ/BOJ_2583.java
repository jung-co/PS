package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_2583 {
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	static int M, N, K;
	
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		visited = new boolean[M][N];
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			recFill(x1, y1, x2, y2);
		}
		
		ArrayList<Integer> arr = new ArrayList<>();
		int stage = 0;
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j] && map[i][j] == 0) {
					int count = DFS(i, j);
					
					stage++;
					arr.add(count);
				}
			}
		} Collections.sort(arr);
		
		System.out.println(stage);
		for(int i=0; i<stage; i++) {
			System.out.print(arr.get(i) + " ");
		}
	}
	
	public static void recFill(int x1, int y1, int x2, int y2) {
		for(int i=y1; i<y2; i++) {
			for(int j=x1; j<x2; j++) {
				if(map[i][j] != 1)
					map[i][j] = 1;
			}
		}
	}
	
	public static int BFS(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		visited[x][y] = true;
		
		int count = 1;
		while(!q.isEmpty()) {
			int[] loc = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = loc[0] + dx[i];
				int ny = loc[1] + dy[i];
				
				if(isCheck(nx, ny)) {
					if(!visited[nx][ny] && map[nx][ny] == 0) {
						q.offer(new int[] {nx, ny});
						visited[nx][ny] = true;
						count++;
					}
				}
			}
		}
		
		return count;
	}
	
	public static int DFS(int x, int y) {
		int count = 0;
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(isCheck(nx, ny)) {
				if(!visited[nx][ny] && map[nx][ny] == 0) {
					int tmp =DFS(nx, ny);
					count += tmp;
				}
			}
		} return count + 1;
	}
	
	public static boolean isCheck(int x, int y) {
		return x>=0 && y>=0 && x<M && y<N;
	}
}
