package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_1966 {
	public static class Value {
		int idx;
		int prior;
		
		public Value(int idx, int prior) {
			this.idx = idx;
			this.prior = prior;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			Queue<Value> q = new LinkedList<>();
			
			for(int j=0; j<n; j++) {
				q.offer(new Value(j, Integer.parseInt(st.nextToken())));
			}
			
			int count = 0;
			while(true){
				boolean flag = false;
				Value val = q.peek();
				
				for(int j=0; j<q.size(); j++) {
					Value tmp = q.poll();
					if(val.prior < tmp.prior) flag = true;
					q.offer(tmp);
				}
				
				if(flag) {
					q.offer(q.poll());
				} else {
					count++;
					if(q.peek().idx == m) break;
					else q.poll();
				}
			}
			
			System.out.println(count);
		}
	}
}
