package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_3009 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] rect = new int[3][2];
		
		for(int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine());
			
			rect[i][0] = Integer.parseInt(st.nextToken());
			rect[i][1] = Integer.parseInt(st.nextToken());
		}

		int x, y;
		if(rect[0][0] == rect[1][0])
			x = rect[2][0];
		else if(rect[0][0] == rect[2][0])
			x = rect[1][0];
		else
			x = rect[0][0];
		
		if(rect[0][1] == rect[1][1])
			y = rect[2][1];
		else if(rect[0][1] == rect[2][1])
			y = rect[1][1];
		else
			y = rect[0][1];
		
		System.out.println(x + " " + y);
	}
}
