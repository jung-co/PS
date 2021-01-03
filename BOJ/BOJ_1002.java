package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1002 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			
			int[][] loc = new int[2][3];
			loc[0][0] = Integer.parseInt(st.nextToken());
			loc[0][1] = Integer.parseInt(st.nextToken());
			loc[0][2] = Integer.parseInt(st.nextToken());
			
			loc[1][0] = Integer.parseInt(st.nextToken());
			loc[1][1] = Integer.parseInt(st.nextToken());
			loc[1][2] = Integer.parseInt(st.nextToken());
			
			int result = LOC(loc);
			System.out.println(result);
		}
	}
	
	public static int LOC(int[][] loc) {
		int x = (int)Math.pow(loc[0][0] - loc[1][0], 2);
		int y = (int)Math.pow(loc[0][1] - loc[1][1], 2);
		int r = x + y;
		
		int p = (int)Math.pow(loc[0][2] + loc[1][2], 2);
		int m = (int)Math.pow(loc[0][2] - loc[1][2], 2);
		
		if(loc[0] == loc[1])
			return -1;
		else if(r > p || r < m)
			return 0;
		else if(r == p || r == m)
			return 1;
		else
			return 2;
	}
}
