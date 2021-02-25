package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_11652 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Long> q = new PriorityQueue<>();
		for(int i=0; i<n; i++) {
			q.offer(Long.parseLong(br.readLine()));
		}
		
		int max = -1;
		int cnt = 0;
		long ans = q.peek();
		long top = q.peek();
		while(!q.isEmpty()) {
			long tmp = q.poll();
			
			if(top == tmp) {
				cnt++;
			} else {
				if(max < cnt) {
					max = cnt;
					ans = top;
				}
				top = tmp;
				cnt = 1;
			}
		}
		
		if(max < cnt) ans = top;
		System.out.println(ans);
	}
}
