package SWEA;

import java.util.*;
import java.io.*;

public class SWEA_2005 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=t; test_case++) {
			StringBuilder sb = new StringBuilder();
			int n = Integer.parseInt(br.readLine());
			int[][] map = new int[n+1][n+1];
			
			map[1][1] = 1;
			for(int i=2; i<n+1; i++) {
				for(int j=1; j<n+1; j++) {
					map[i][j] = map[i-1][j-1] + map[i-1][j];
				}
			}

            sb.append("#").append(test_case).append("\n");
			for(int i=1; i<n+1; i++) {
				for(int j=1; j<i+1; j++) {
					sb.append(map[i][j]).append(" ");
				} sb.append("\n");
			}
			
			System.out.print(sb);
		}
	}
}
