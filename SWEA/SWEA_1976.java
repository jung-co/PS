package SWEA;

import java.util.*;
import java.io.*;

public class SWEA_1976 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=test_case; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int h1 = Integer.parseInt(st.nextToken());
			int m1 = Integer.parseInt(st.nextToken());
			int h2 = Integer.parseInt(st.nextToken());
			int m2 = Integer.parseInt(st.nextToken());
			
			int h = h1 + h2;
			int m = m1 + m2;
			if(m>=60) {
				m = m-60;
				h += 1;
			}
			
			h = h%12;
			if(h == 0) h = 12;
			
			System.out.format("#%d %d %d\n", t, h, m);
		}
	}
}
