package SWEA;

import java.util.*;
import java.io.*;

public class SWEA_1948 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		int[] day = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		for(int test_case=1; test_case<=t; test_case++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ");
			
			st = new StringTokenizer(br.readLine());
			int m1 = Integer.parseInt(st.nextToken());
			int d1 = Integer.parseInt(st.nextToken());
			int m2 = Integer.parseInt(st.nextToken());
			int d2 = Integer.parseInt(st.nextToken());
			
			int sum = day[m1] - d1 + d2 + 1;
			if(m1 == m2) sum = d2 - d1 + 1;
			for(int i=m1+1; i<m2; i++) {
				sum += day[i];
			} sb.append(sum);
			
			System.out.println(sb);
		}
	}
}
