package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_1744 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}		
		Arrays.sort(arr);
		
		int left = 0;
		int right = n-1;
		
		long sum = 0;
		while(left<right) {
			if(arr[left]<1 && arr[left+1]<1)
				sum += arr[left] * arr[left+1];
			else break;
			
			left+=2;
		}
		
		while(right>0) {
			if(arr[right]>1 && arr[right-1]>1) {
				sum += arr[right] * arr[right-1];
			} else break;
			
			right -= 2;
		}
		
		while(right>=left) {
			sum += arr[right];
			right--;
		}
		
		System.out.println(sum);
	}
}
