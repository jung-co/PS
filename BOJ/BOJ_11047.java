package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_11047 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] list = new int[n];
		for(int i=0; i<n; i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
		
		int idx = n-1;
		int cnt = 0;
		while(k > 0) {
			 if((k-list[idx]) >= 0) {
				 k -= list[idx];
				 cnt++;
			 } else {
				 idx--;
			 }
		}
		
		System.out.println(cnt);
	}
}
