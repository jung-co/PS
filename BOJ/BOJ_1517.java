package BOJ;

import java.util.*;
import java.io.*;

/* https://log-laboratory.tistory.com/72 */
public class BOJ_1517 {
	static int[] arr;
	static int[] arrCopy;
	static long ans;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		arrCopy = new int[n];
				
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		ans = 0;
		merge(0, n-1);
		System.out.println(ans);
	}
	
	public static void merge(int left, int right) {
		if(left != right) {
			int mid = (left + right) / 2;
			merge(left, mid);
			merge(mid+1, right);
			mergeSort(left, right);
		}
	}
	
	public static void mergeSort(int left, int right) {
		int mid = (left + right) / 2;
		int l = left;
		int r = mid + 1;
		
		int idx = left;
		while(l<=mid && r<=right) {
			if(arr[l] > arr[r]) {
				arrCopy[idx++] = arr[r++];
				ans += mid-l+1;
			} else {
				arrCopy[idx++] = arr[l++];
			}
		}
		
		if(l > mid) {
			while(r <= right)
				arrCopy[idx++] = arr[r++];
		} else {
			while(l <= mid)
				arrCopy[idx++] = arr[l++];
		}
		
		for(idx = left; idx<=right; idx++) {
			arr[idx] = arrCopy[idx];
		}
	}
}
