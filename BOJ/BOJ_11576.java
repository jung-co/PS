package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_11576 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(br.readLine());
		
		int sum = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=m-1; i>=0; i--) {
			sum += Integer.parseInt(st.nextToken()) * Math.pow(a, i);
		}
		
		Stack<Integer> stack = new Stack<>();
		while(sum > 0) {
			stack.push(sum%b);
			sum /= b;
		}
		
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
			
			if(!stack.isEmpty()) sb.append(" ");
		}
		
		System.out.println(sb);
	}
}
