package SWEA;

import java.util.*;
import java.io.*;

public class SWEA_1959 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=t; test_case++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[] a = new int[n];
			int[] b = new int[m];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<m; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = Integer.MIN_VALUE;
			if(n>m) {
				for(int i=0; i<n-m+1; i++) {
					int sum = 0;
					for(int j=0; j<m; j++) {
						sum += b[j] * a[i+j];
					}
					
					max = Math.max(sum, max);
				} sb.append(max);
			} else {
				for(int i=0; i<m-n+1; i++) {
					int sum = 0;
					for(int j=0; j<n; j++) {
						sum += a[j] * b[i+j];
					}
					
					max = Math.max(sum, max);
				} sb.append(max);
			}
			
			System.out.println(sb);
		}
	}
}
