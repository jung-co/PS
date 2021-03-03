package SWEA;

import java.util.*;
import java.io.*;

public class SWEA_1954 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=t; test_case++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append("\n");
			int n = Integer.parseInt(br.readLine());
			int[][] map = new int[n][n];

			int oper = 1;
			int num = 1;
			int x_idx = -1, y_idx = 0;
			while(n > 0) {
				for(int i=0; i<n; i++) {
					x_idx+=oper;
					map[y_idx][x_idx] = num;
					num++;
				}
				
				n--;
				for(int i=0; i<n; i++) {
					y_idx+=oper;
					map[y_idx][x_idx] = num;
					num++;
				}
				
				oper *= -1;
			}
			
			for(int i=0; i<map.length; i++) {
				for(int j=0; j<map[0].length; j++) {
					sb.append(map[i][j]).append(" ");
				} sb.append("\n");
			}
			
			System.out.print(sb);
		}
	}
}
