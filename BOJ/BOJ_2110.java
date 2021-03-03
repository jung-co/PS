package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_2110 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int left = 1; // 최소 거리
		int right = arr[n-1] - left;
		int ans = 0;
		while(left <= right) {
			int mid = (left + right)/2;
			int dist = 0;
			int start = arr[0];
			
			int cnt = 1;
			for(int i=1; i<n; i++) {
				dist = arr[i] - start;
				if(mid <= dist) {
					cnt++;
					start = arr[i];
				}
			}
			
			if(cnt >= c) {
				ans = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		System.out.println(ans);
	}
}
