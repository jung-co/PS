package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9020 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			int n = Integer.parseInt(br.readLine());
			boolean[] num = new boolean[n+1];
			
			num[1] = true;
			for(int j=2; j<=Math.sqrt(n); j++) {
				for(int k=j*2; k<=n; k+=j) {
					num[k] = true;
				}
			}
			
			int a = 0, b = 0;
			int min = Integer.MAX_VALUE;
			for(int j=2; j<=n/2; j++) {
				int tmp = n - j;
				if(!num[tmp] && !num[j]) {
					if(min > tmp - j){
						min = tmp - j;
						a = j; b = tmp;
					}
				}
			}
			
			System.out.println(a + " " + b);
		}
	}
}
