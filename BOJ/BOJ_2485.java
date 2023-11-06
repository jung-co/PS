package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2485 {
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	static int N;
	static int count;
	static int height;
	
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int minVal = Integer.MAX_VALUE;
		int maxVal = Integer.MIN_VALUE;
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			String[] str = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				
				minVal = Math.min(minVal, map[i][j]);
				maxVal = Math.max(maxVal, map[i][j]);
			}
		}
		
		int max = -1;
		for(int k=0; k<=maxVal; k++) {
			visited = new boolean[N][N];
			count = 0;
			height = k;
            
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]>k && !visited[i][j]) {
						DFS(i, j);
						count++;
					}
				}
			}
			int cnt = count;
			max = Math.max(max, count);
		}
		
		System.out.println(max);
	}
	
	public static void DFS(int x, int y) {
		if(map[x][y]<=height || visited[x][y]) return;
		
		visited[x][y] = true;
		for(int i=0; i<4; i++) {
			int ex = x + dx[i];
			int ey = y + dy[i];
			
			if(isCheck(ex, ey)) {
				DFS(ex, ey);
			}
		}
	}
	
	public static boolean isCheck(int i, int j) {
		return i>=0 && j>=0 && i<N && j<N;
	}
}
