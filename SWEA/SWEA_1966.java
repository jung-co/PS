package SWEA;

import java.util.*;
import java.io.*;

public class SWEA_1966 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=t; test_case++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case);
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			int[] list = new int[n];
			for(int i=0; st.hasMoreTokens(); i++) {
				list[i] = Integer.parseInt(st.nextToken());
			} Arrays.sort(list);
			
			for(int i=0; i<n; i++) {
				sb.append(" ").append(list[i]);
			}
			
			System.out.println(sb);
		}
	}
}
