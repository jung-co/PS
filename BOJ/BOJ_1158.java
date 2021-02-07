package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_1158 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=n; i++) {
			q.add(i);
		}
		
		int count = k;
		Queue<Integer> ans = new LinkedList<>();
		while(!q.isEmpty()) {
			count--;
			
			if(count == 0) {
				ans.add(q.poll());
				count = k;
			} else {
				q.add(q.poll());
			}
		}
		
		sb.append("<");
		while(!ans.isEmpty()) {
			sb.append(ans.poll());
			if(!ans.isEmpty()) sb.append(", ");
		}
		
		System.out.println(sb + ">");
	}
}
