package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_11279 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
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
