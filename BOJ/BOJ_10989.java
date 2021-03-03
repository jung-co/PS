package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_10989 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		int[] cnt = new int[10001];
		for(int i=0; i<n; i++) {
			int idx = Integer.parseInt(br.readLine());
			cnt[idx]++;
		}
		
		for(int i=1; i<10001; i++) {
			for(int j=0; j<cnt[i]; j++) {
				sb.append(i).append('\n');
			}
		}
		
		System.out.println(sb);
	}
}
