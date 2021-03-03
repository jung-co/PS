package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_1451 {
	static int n, m;
	static int[][] map;
	static long[][] sum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n+1][m+1];
		for(int i=1; i<=n; i++) {
			String tmp = br.readLine();
			for(int j=1; j<=m; j++) {
				map[i][j] = tmp.charAt(j-1) - '0';
			}
		}
		
		sum = new long[n+1][m+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + (long)map[i][j];
			}
		}
		
		long[][] tmp = sum;
		
		long ans = 0;
		// 세로로 세 직사각형 자르기
		for(int i=1; i<=m-2; i++) {
			for(int j=i+1; j<m-1; j++) {
				long r1 = sum(1, 1, n, i);
				long r2 = sum(1, i+1, n, j);
				long r3 = sum(1, j+1, n, m);
				
				if(ans < r1 * r2 * r3) {
					ans = r1 * r2 * r3;
				}
			}
		}
		
		// 가로로 세 직사각형 자르기
		for(int i=1; i<=n-2; i++) {
			for(int j=i+1; j<=n-1; j++) {
				long r1 = sum(1, 1, i, m);
				long r2 = sum(i+1, 1, j, m);
				long r3 = sum(j+1, 1, n, m);
				
				if(ans < r1 * r2 * r3) {
					ans = r1 * r2 * r3;
				}
			}
		}
		
		// (왼쪽)세로 통 하나 + (오른쪽)가로 두 개
		for(int i=1; i<=n-1; i++) {
			for(int j=1; j<=m-1; j++) {
				long r1 = sum(1, 1, n, j);
				long r2 = sum(1, j+1, i, m);
				long r3 = sum(i+1, j+1, n, m);
				
				if(ans < r1 * r2 * r3) {
					ans = r1 * r2 * r3;
				}

				// (왼쪽)가로 두 개 + (오른쪽)세로 통 하나
				r1 = sum(1, 1, i, j);
				r2 = sum(i+1, 1, n, j);
				r3 = sum(1, j+1, n, m);
				
				if(ans < r1 * r2 * r3) {
					ans = r1 * r2 * r3;
				}
				
				// (위쪽)가로 통 하나 + (아래쪽)세로 두 개
				r1 = sum(1, 1, i, m);
				r2 = sum(i+1, 1, n, j);
				r3 = sum(i+1, j+1, n, m);
				
				if(ans < r1 * r2 * r3) {
					ans = r1 * r2 * r3;
				}
				
				// (아래쪽) 가로 통 하나 + (위쪽) 세로 두 개
				r1 = sum(1, 1, i, j);
				r2 = sum(1, j+1, i, m);
				r3 = sum(i+1, 1, n, m);
				
				if(ans < r1 * r2 * r3) {
					ans = r1 * r2 * r3;
				}
			}
		}
		
		System.out.println(ans);
	}
	
	public static long sum(int start_x, int start_y, int end_x, int end_y) {
		return sum[end_x][end_y] - sum[end_x][start_y-1] - sum[start_x-1][end_y] + sum[start_x-1][start_y-1];
	}
}
