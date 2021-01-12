package SWEA;

import java.util.*;
import java.io.*;

public class SWEA_1285 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=t; test_case++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#" + test_case + " ");
			
			int count = 1;
			int min = Integer.MAX_VALUE;
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				int tmp = Integer.parseInt(st.nextToken());
				int dist = Math.abs(tmp - 0);
				
				if(min > dist) {
					min = dist;
				} else if(min == dist) {
					count++;
				}
			}sb.append(min + " " + count);
			
			System.out.println(sb);
		}
	}
}
