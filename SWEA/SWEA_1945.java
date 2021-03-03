package SWEA;

import java.util.*;
import java.io.*;

public class SWEA_1945 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		int[] prime = {2, 3, 5, 7, 11};
		for(int test_case=1; test_case<=t; test_case++) {
			int[] prime_cnt = new int[5];
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case);
			
			int idx = 0;
			int n = Integer.parseInt(br.readLine());
			while(n>1) {
				if(n%prime[idx] == 0) {
					prime_cnt[idx]++;
					n /= prime[idx];
				} else {
					idx++;
				}
			}
			
			for(int i=0; i<5; i++) {
				sb.append(" ").append(prime_cnt[i]);
			}
			
			System.out.println(sb);
		}
	}
}
