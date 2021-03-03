package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_1654 {
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		arr = new int[k];
		for(int i=0; i<k; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		} Arrays.sort(arr);
		
		long left = 1;
		long right = arr[k-1];
		long middle = 0;
		
		while(left<=right) {
			middle = (left+right)/2;
			
			long cnt = 0;
			for(int i=0; i<k; i++) {
				cnt+= arr[i]/middle;
			}
			
			if(cnt < n) {
				right = middle-1;
			} else {
				left = middle+1;
			}
		}
		
		System.out.println(right);
	}
}
