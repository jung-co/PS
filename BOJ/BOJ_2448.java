package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_2448 {
	static char[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		map = new char[n][2*n-1];
		for(int i=0; i<n; i++) {
			Arrays.fill(map[i], ' ');
		}
		
		star(0, 0, n);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			for(int j=0; j<2*n-1; j++) {
				sb.append(map[i][j]);
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void star(int x, int y, int n) {
		if(n == 3) {
			map[x][y+2] = map[x+1][y+1] = map[x+1][y+3] = '*';
			for(int i=y; i<y+5; i++) {
				map[x+2][i] = '*';
			}
			
			return;
		}
	 	
		star(x, y+n/2, n/2);
		star(x+n/2, y, n/2);
		star(x+n/2, y+n, n/2);
	}
}
