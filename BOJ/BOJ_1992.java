package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_1992 {
	static int n;
	static char[][] map;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		map = new char[n][n];
		for(int i=0; i<n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		zip(0, 0, n);
		System.out.println(sb);
	}
	
	public static void zip(int x, int y, int len) {
		if(check(x, y, len)) {
			sb.append(map[x][y]);
		} else {
			int tmp = len/2;
			
			sb.append("(");
			zip(x, y, tmp);
			zip(x, y+tmp, tmp);
			zip(x+tmp, y, tmp);
			zip(x+tmp, y+tmp, tmp);
			sb.append(")");
		}
	}
	
	public static boolean check(int x, int y, int len) {
		char tmp = map[x][y];
		for(int i=x; i<x+len; i++) {
			for(int j=y; j<y+len; j++) {
				if(map[i][j] != tmp)
					return false;
			}
		}
		
		return true;
	}
}
