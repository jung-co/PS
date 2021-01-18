package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_1927 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
				
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for(int i=0; i<n; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if(tmp == 0) {
				if(q.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(q.poll());
				}
			} else {
				q.add(tmp);
			}
		}
	}
}
