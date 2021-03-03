package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_10820 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringBuilder sb = new StringBuilder();
			String str = br.readLine();
			
			if(str == null) break;

			int[] cnt = new int[4];
			for(int i=0; i<str.length(); i++) {
				char ch = str.charAt(i);
				
				if(ch >= 'a' && ch <= 'z') cnt[0]++;
				else if(ch >= 'A' && ch <= 'Z') cnt[1]++;
				else if(ch >= '0' && ch <= '9') cnt[2]++;
				else cnt[3]++;
			}

			for(int i=0; i<4; i++) {
				sb.append(cnt[i] + " ");
			}
			
			System.out.println(sb);
		}
		
	}
}
