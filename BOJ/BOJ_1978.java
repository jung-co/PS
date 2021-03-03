package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_1978 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		int max = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(max < arr[i]) max = arr[i];
		}
		
		boolean[] prime = new boolean[max+1];
		prime[1] = true;
		for(int i=2; i<=Math.sqrt(max); i++) {
			for(int j=i+i; j<=max; j+=i) {
				prime[j] = true;
			}
		}
		
		int cnt = 0;
		for(int i=0; i<n; i++) {
			if(!prime[arr[i]]) cnt++;
		}
		
		System.out.println(cnt);
	}
}
