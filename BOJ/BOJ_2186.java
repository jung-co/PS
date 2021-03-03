package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_2186 {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int n, m, k;
	static char[][] map;
	static char[] str;
	
	static int[][][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		for(int i=0; i<n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		str = br.readLine().toCharArray();
		dp = new int[n][m][str.length];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}
		
		int ans = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == str[0]) {
					ans += search(i, j, 0);
				}
			}
		}
		
		System.out.println(ans);
	}
	
	private static int search(int x, int y, int len) {
		if(len == str.length-1) return dp[x][y][len] = 1;
		if(dp[x][y][len]!= -1) return dp[x][y][len];
		
		dp[x][y][len] = 0;
		for(int i=0; i<4; i++) {
			for(int j=1; j<=k; j++) {
				int nx = x + dx[i]*j;
				int ny = y + dy[i]*j;
				
				if(nx>=0 && nx<n && ny>=0 && ny<m) {
					if(map[nx][ny] == str[len+1]) {
						dp[x][y][len] += search(nx, ny, len+1);
					}
				}
			}
		}
		
		return dp[x][y][len];
	}
}
