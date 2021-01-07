package SWEA;

import java.util.*;
import java.io.*;

public class SWEA_1859 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[] arr;
		
		for(int testCase=1; testCase<=t; testCase++) {
			int n = Integer.parseInt(br.readLine());
			arr = new int[n];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; st.hasMoreTokens(); i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int start=0, end=0;
			long sum = 0;
			for(int i=0; i<n-1; i++) {
				if(arr[i+1] > arr[i]) {
					end = i+1;
					if(end == n-1) {
						for(int j=start; j<end; j++) {
							sum += arr[end] - arr[j];
						}
					}
				} else if(arr[i+1] < arr[i]) {
					for(int j=start; j<end; j++) {
						sum += arr[end] - arr[j];
						start = end + 1;
					}
				}
			}
			
			System.out.println("#" + testCase + " " + sum);
		}
	}
}
