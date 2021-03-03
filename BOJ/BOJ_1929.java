package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_1929 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n+1];
		
		boolean[] prime = new boolean[n+1];
		prime[1] = true;
		for(int i=2; i<=Math.sqrt(n); i++) {
			for(int j=i+i; j<=n; j+=i) {
				prime[j] = true;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=m; i<=n; i++) {
			if(!prime[i]) sb.append(i + "\n");
		}
		
		System.out.println(sb);
	}
}
