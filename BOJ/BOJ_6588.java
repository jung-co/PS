package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_6588 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] prime = new boolean[1000001];
		prime[1] = true;
		for(int i=2; i<=Math.sqrt(1000000); i++) {
			for(int j=i+i; j<prime.length; j+=i) {
				prime[j] = true;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(true) {
			int n = Integer.parseInt(br.readLine());
			
			if(n==0) break;
			
			int a = 0;
			int b = n-a;
			for(a=3; a<=n/2; a++) {
				b = n-a;
				if(!prime[a] && !prime[b]) {
					break;
				}
			}
			
			if(prime[a] || prime[b]) {
				sb.append("Goldbach's conjecture is wrong.\n");
			} else sb.append(n + " = " + a + " + " + b + "\n");
		}
		
		System.out.println(sb);
	}
}
