package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_11005 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
	
		StringBuilder sb = new StringBuilder();
		Stack<Character> q = new Stack<>();
		int re = 0;
		while(n > 0) {
			re = n % b;
			if(re >= 10) {
				q.push((char)(re - 10 + 'A'));
			} else {
				q.push((char)(re + '0'));
			}
			
			n /= b;
		} 
		
		while(!q.isEmpty()) {
			sb.append(q.pop());
		}
		
		System.out.println(sb);
	}
	
}
