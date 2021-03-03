package SWEA;

import java.util.*;
import java.io.*;

public class SWEA_1284 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=t; test_case++) {
			st = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case);
			
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			int a = w * p;
			int b = q;
			
			if(w > r) {
				w = w - r;
				b = b + w * s;
			}
			
			System.out.println(sb + " " + Math.min(a, b));
		}
	}
}
