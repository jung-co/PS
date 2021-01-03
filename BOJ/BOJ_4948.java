package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_4948 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) break;
			
			boolean[] num = new boolean[2*n+1];
			int count = 0;
			
			num[1] = true;
			for(int i=2; i<=Math.sqrt(2*n); i++) {
				for(int j=i*2; j<=2*n; j+=i) {
					num[j] = true;
				}
			}
			
			for(int i=n+1; i<2*n; i++) {
				if(!num[i]) {
					count++;
				}
			} System.out.println(count);
		}
	}
}
