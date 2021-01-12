package SWEA;

import java.util.*;
import java.io.*;

public class SWEA_1979 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int test_case = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=test_case; t++) {
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[n+2][n+2];
			for(int i=1; i<=n; i++) {
				st = new StringTokenizer(br.readLine());
				
				for(int j=1; j<=n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int result = 0;
			
			for(int idx_x=1; idx_x<=n; idx_x++) {
				for(int idx_y=1; idx_y<=n; idx_y++) {
					int count = 0;
					
					if(map[idx_x][idx_y] == 1) {
						if(map[idx_x][idx_y-1] == 0) { // 가로
							for(int j=idx_y; map[idx_x][j] != 0; j++) {
								count++;
							} if(count == k) result++;
						}
						
						count = 0;
						if(map[idx_x-1][idx_y] == 0) { // 세로
							for(int j=idx_x; map[j][idx_y] != 0; j++) {
								count++;
							} if(count == k) result++;
						}
					}
				}
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
}