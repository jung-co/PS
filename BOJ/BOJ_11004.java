package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_11004 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> q = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			q.offer(Integer.parseInt(st.nextToken()));
		}
		
		for(int i=0; i<k; i++) {
			q.poll();
		}
		
		System.out.println(q.peek());
	}
}
