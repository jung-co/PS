package SWEA;

import java.util.*;
import java.io.*;

public class SWEA_2001 {
	static int n, m;
	static int[][] map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=t; test_case++) {
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			map = new int[n][n];
			for(int i=0; i<n; i++) {
				String[] tmp = br.readLine().split(" ");
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(tmp[j]);
				}
			}
			
			int max = -1;
			for(int i=0; i<n-m; i++) {
				for(int j=0; j<n-m; j++) {
					int tmp = fly(i, j);
					if(max < tmp) max = tmp;
				}
			}
			
			System.out.println("#" + test_case + " " + max);
		}
	}
	
	public static int fly(int x, int y) {
		int sum = 0;
		for(int i=x; i<x+m; i++) {
			for(int j=y; j<y+m; j++) {
				sum += map[i][j];
			}
		}
		
		return sum;
	}
}
