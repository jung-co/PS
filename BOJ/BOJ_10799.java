package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_10799 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = 0;
		String str = br.readLine();
		Stack<Character> st = new Stack<>();
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			
			if(ch == '(') {
				st.push('(');
			} else {
				char tmp = str.charAt(i-1);
				if(tmp == '(') {
					st.pop();
					count += st.size();
				} else {
					st.pop();
					count += 1;
				}
				
			}
		}
		
		System.out.println(count);
	}
}
