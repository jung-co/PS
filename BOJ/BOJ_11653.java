package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_11653 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int idx = 2;
		StringBuilder sb = new StringBuilder();
		while(n > 1) {
			if(n%idx == 0) {
				sb.append(idx + "\n");
				n /= idx;
			} else idx++;
		}
		
		System.out.println(sb);
	}
}
