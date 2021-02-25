package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_2089 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		if(n == 0) {
			System.out.println(0);
			return;
		}
		
		StringBuilder sb = new StringBuilder();
		while(n != 1) {
			sb.append(Math.abs(n  % -2));
			n = (int)Math.ceil((double)n/(-2));
		}
		
		sb.append(n);
		
		System.out.println(sb.reverse());
	}
}
