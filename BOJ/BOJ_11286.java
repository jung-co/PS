package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_11286 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				int n1 = Math.abs(o1);
				int n2 = Math.abs(o2);
								
				if(n1 != n2) return n1 - n2;
				return o1 > o2 ? 1 : -1;
			}
		});
		
		for(int i=0; i<n; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if(tmp == 0) {
				if(q.isEmpty()) sb.append(0);
				else sb.append(q.poll());
				sb.append("\n");
			} else q.add(tmp);
		}
		
		System.out.println(sb);
	}
}
