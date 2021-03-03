package SWEA;

import java.util.*;
import java.io.*;

public class SWEA_1983 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int test_case = Integer.parseInt(br.readLine());
		
		String[] score = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
		for(int t=1; t<=test_case; t++) {		
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			double[] list = new double[n];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				
				int m = Integer.parseInt(st.nextToken());
				int f = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				
				list[i] = (m*35 + f*45 + w*20);
			}
			
			double k_student = list[k-1];
			Arrays.sort(list);
			
			int idx = 0;
			int count = 0;
			for(int i=n-1; i>=0; i--) {
				if(k_student == list[i]) {
					sb.append(score[idx]);
					break;
				}
				
				count++;
				if(count == n/10) {
					count = 0;
					idx++;
				}
			}
			
			System.out.println(sb);
		}
	}
}