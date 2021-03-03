package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_1107 {
	static boolean[] broken = new boolean[10];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			int idx = Integer.parseInt(st.nextToken());
			broken[idx] = true;
		}
		
		int ans = Math.abs(n - 100);
		for(int i=0; i<1000000; i++) {
			int length = check(i);
			
			if(length > 0) {
				int press = Math.abs(i - n);
				if(ans > length + press) {
					ans = length + press;
				}
			}
		}
		
		System.out.println(ans);
	}
	
	public static int check(int num) {
		if(num == 0) {
			return broken[0] ? 0 : 1;
		}
		
		int length = 0;
		while(num > 0) {
			if(broken[num % 10]) return 0;
			
			length ++;
			num /= 10;
		}
		
		return length;
	}
}
