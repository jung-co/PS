package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_1780 {
	static int[][] map;
	static int[] count = new int[3];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		paper(0, 0, n);
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<3; i++) {
			sb.append(count[i]).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void paper(int x, int y, int n) {
		if(check(x, y, n)) {
			count[map[x][y]+1]++;
		} else {
			int nl = n/3;
			
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					paper(x+i*nl, y+j*nl, nl);
				}
			}
		}
	}
	
	public static boolean check(int x, int y, int len) {
		int tmp = map[x][y];
		
		for(int i=x; i<x+len; i++) {
			for(int j=y; j<y+len; j++) {
				if(map[i][j] != tmp)
					return false;
			}
		}
		
		return true;
	}
}
