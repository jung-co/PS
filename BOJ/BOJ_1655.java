package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_1655 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		Queue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
		Queue<Integer> min = new PriorityQueue<>();
		for(int i=1; i<=n; i++) {
			int tmp = Integer.parseInt(br.readLine());
			
			if(i%2 != 0) max.add(tmp);
			else min.add(tmp);
			
			if(!min.isEmpty() && !max.isEmpty()) {
				if(max.peek() > min.peek()) {
					int t = min.poll();
					min.add(max.poll());
					max.add(t);
				}
			} sb.append(max.peek() + "\n");
		}
		
		System.out.println(sb);
	}
}
