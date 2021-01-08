package SWEA;

import java.util.*;
import java.io.*;

public class SWEA_1961 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=t; test_case++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append("\n");
			
			int n = Integer.parseInt(br.readLine());
			int[][] map = new int[n][n];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[][][] map_lot = new int[3][n][n];
			for(int d=0; d<3; d++) {
				for(int i=0; i<n; i++) {
					for(int j=0; j<n; j++) {
						map_lot[d][j][n-i-1] = map[i][j];
					}
				} map = map_lot[d];
			}
			
			for(int i=0; i<n; i++) {
				for(int d=0; d<3; d++) {
					for(int j=0; j<n; j++) {
						sb.append(map_lot[d][i][j]);
					} sb.append(" ");
				} sb.append("\n");
			}
			
			System.out.print(sb);
		}
	}
}
