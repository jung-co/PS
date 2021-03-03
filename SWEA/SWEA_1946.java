package SWEA;

import java.util.*;
import java.io.*;

public class SWEA_1946 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=t; test_case++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append("\n");
			
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n*2];
			for(int i=0; i<n*2; i++) {
				st = new StringTokenizer(br.readLine());
				
				arr[i] = st.nextToken().charAt(0);
				arr[++i] = Integer.parseInt(st.nextToken());
			}
			
			int count = 10;
			for(int i=0; i<n*2; ) {				
				if(arr[i+1]>0) {
					sb.append((char)arr[i]);
					arr[i+1]--;
				} else {
					i += 2;
					continue;
				}
				
				count--;
				if(count == 0) {
					sb.append("\n");
					count = 10;
				}
			}
			
			System.out.println(sb);
		}
	}
}
