package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_1182 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int count = 0;
		for(int i=1; i<=n; i++) {
			int end = n-i;
			for(int idx=0; idx<end+1; idx++) {
				int sum = 0;
				for(int j=idx; j<idx+i; j++) {
					sum+=arr[j];
				}
				
				if(sum == s) count++;
			}
		}
		
		System.out.println(count);
	}
}
