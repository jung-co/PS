package SWEA;

import java.util.*;
import java.io.*;

public class SWEA_1926 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		boolean check = false;
		
		for(int i=1; i<=n; i++) {
			String[] str = Integer.toString(i).split("");
			for(int j=0; j<str.length; j++) {
				if(str[j].equals("3") || str[j].equals("6") || str[j].equals("9")) {
					sb.append("-");
					check = true;
				}
			}
			
			if(check) {
				sb.append(" ");
				check = false;
			} else sb.append(i).append(" ");
		}
		
		System.out.println(sb);
	}
}
