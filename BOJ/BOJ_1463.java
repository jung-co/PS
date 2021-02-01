package BOJ;

import java.util.*;

public class BOJ_1463 {
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		arr = new int[n+1];
		
		System.out.println(DP(n)+1);
	}
	
	public static int DP(int n) {
		if(n==1) return 0;
		if(arr[n] > 0) return arr[n];
		
		arr[n] = DP(n-1) + 1;
		if(n%3==0) {
			arr[n/3] = DP(n/3) + 1;
			arr[n] = Math.min(arr[n/3], arr[n]);
		} if(n%2==0) {
			arr[n%2] = DP(n/2) + 1;
			arr[n] = Math.min(arr[n/2], arr[n]);
		}
		
		return arr[n];
	}
}
