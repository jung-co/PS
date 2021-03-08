package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_1987 {
	static int max = 1;
	
	static int r, c;
	static char[][] map;
	static boolean[] alpha = new boolean[26];
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		for(int i=0; i<r; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		alpha[map[0][0] - 'A'] = true;
		DFS(0, 0, 1);
		
		System.out.println(max);
	}
	
	public static void DFS(int x, int y, int cnt) {
		alpha[map[x][y] - 'A'] = true;
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0 && ny>=0 && nx<r && ny<c) {
				if(!alpha[map[nx][ny] - 'A']) {
					DFS(nx, ny, cnt+1);
				}
			}
		}
		alpha[map[x][y] - 'A'] = false;
		if(max < cnt) max = cnt;
	}
}
