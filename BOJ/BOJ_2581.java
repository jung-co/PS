package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_2581 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		boolean[] num = new boolean[N+1];
		num[1] = true;
		for(int i=2; i<=Math.sqrt(N); i++) {
			for(int j=i*2; j<=N; j+=i) {
				num[j] = true;
			}
		}
		
		int min = -1;
		int sum = 0;
		for(int i=M; i<=N; i++) {
			if(!num[i]) {
				if(min == -1)
					min = i;
				sum += i;
			}
		}
		
		if(sum != 0) {
			System.out.println(sum);
		} System.out.println(min);
	}
}
