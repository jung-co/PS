package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_10828 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		Stack<Integer> stack = new Stack<>();
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			String str = st.nextToken();
			if(str.equals("push")) {
				stack.push(Integer.parseInt(st.nextToken()));
				continue;
			}
			else if(str.equals("pop")) {
				if(!stack.isEmpty()) sb.append(stack.pop());
				else sb.append(-1);
			}
			else if(str.equals("top")) {
				if(!stack.isEmpty()) sb.append(stack.peek());
				else sb.append(-1);
			}
			else if(str.equals("size")) sb.append(stack.size());
			else {
				if(stack.isEmpty()) sb.append(1);
				else sb.append(0);
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
