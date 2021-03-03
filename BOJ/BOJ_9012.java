package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_9012 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			Stack<String> st = new Stack<>();
			String[] str = br.readLine().split("");
			
			boolean check = true;
			for(int j=0; j<str.length; j++) {
				if(str[j].equals("(")) st.push("(");
				else {
					if(st.isEmpty()) {
						check = false;
						break;
					} else st.pop();
				}
			} if(!st.isEmpty()) check = false;
			
			if(check) sb.append("YES");
			else sb.append("NO");
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
