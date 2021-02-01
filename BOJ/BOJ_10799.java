package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_10799 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int result = 0;
		int count = 0;
		String str = br.readLine();
		Stack<Character> st = new Stack<>();
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			
			if(ch == '(') {
				st.push('(');
				count++;
			} else {
				count--;
				st.pop();
				result += count;
			}
		}
		
		System.out.println(result);
	}
}
