package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_11728 {
	static int[] list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for(int i=0; i<2; i++) {
			st = new StringTokenizer(br.readLine());
			
			while(st.hasMoreTokens()) {
				q.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!q.isEmpty()) {
			sb.append(q.poll() + " ");
		}
		
		System.out.println(sb);
	}
}
