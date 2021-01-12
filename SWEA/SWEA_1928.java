package SWEA;

import java.util.*;
import java.io.*;

public class SWEA_1928 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=t; test_case++) {
			StringBuilder sb = new StringBuilder();
			//sb.append("#").append(test_case);

			String str = br.readLine();
			for(int i=0; i<str.length(); i++) {
				char ch = str.charAt(i);
				int tmp;
				
				if(ch >= 'A' && ch <= 'Z')
					tmp = ch - 'A';
				else if(ch>='a' && ch<='z')
					tmp = ch - 'a' + 26;
				else if(ch>='0' && ch<='9')
					tmp = ch - '0' + 52;
				else if(ch == '+')
					tmp = 62;
				else
					tmp = 63;
				
				sb.append(String.format("%6s", Integer.toBinaryString(tmp)).replace(' ', '0'));
			}
			
			StringBuilder result = new StringBuilder();
			for(int i=0; i<sb.length(); i+=8) {
				char tmp = (char)Integer.parseInt(sb.substring(i, i+8), 2);
				result.append(tmp);
			}
			
			System.out.println("#" + test_case + " " + result);
		}
	}
}
