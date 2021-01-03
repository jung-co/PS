package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_11653 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		boolean[] prime = new boolean[n+1];
		for(int i=2; i<=Math.sqrt(n); i++) {
			for(int j=i+i; j<=n; j+=i) {
				prime[j] = true;
			}
		}
		
		int idx = 2;
		while(true) {
			if(n == 1) return;
			
			if(!prime[idx]) {
				if(n % idx == 0){
					System.out.println(idx);
					n /= idx;
				} else 
					idx++;
			} else
				idx++;
		}
	}
}
