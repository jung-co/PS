package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_11054 {
	static int[] arr;
	
	static int[] up;
	static int[] bi;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		up = new int[n];
		bi = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<n; i++) {
			UP(i);
		}
		
		int max = 0;
		for(int i=0; i<n; i++) {
			max = Math.max(max, DOWN(i));
		}
		
		System.out.println(max);
	}
	
	static int UP(int t) {
		if(up[t] > 0) return up[t];
		
		up[t] = 1;
		for(int i=t-1; i>=0; i--) {
			if(arr[i] < arr[t]) {
				up[t] = Math.max(up[t], UP(i) + 1);
			}
		}
		
		return up[t];
	}
	
	static int DOWN(int t) {
		if(bi[t] > 0) return bi[t];
		
		bi[t] = up[t];
		for(int i=t-1; i>=0; i--) {
			if(arr[i] > arr[t]) {
				bi[t] = Math.max(bi[t], DOWN(i) + 1);
			}
		}
		
		return bi[t];
	}
}
