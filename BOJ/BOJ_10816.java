package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_10816 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<m; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			
			int l = start(arr, n, tmp);
			int r = end(arr, n, tmp);
			
			sb.append(r-l + " ");
		}
		
		System.out.println(sb);
	}
	
	public static int start (int[] arr, int n, int num) {
		int left = 0;
		int right = n-1;
		
		int mid;
		while(left < right) {
			mid = (left + right) / 2;
			
			if(arr[mid] < num) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		
		return right;
	}
	
	public static int end (int[] arr, int n, int num) {
		int left = 0;
		int right = n-1;
		
		int mid;
		while(left < right) {
			mid = (left + right) / 2;
			if(arr[mid] > num)
				right = mid;
			else left = mid + 1;
		}
		
		if(arr[right] == num) right++;
		return right;
	}
}
