package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_10866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> dq = new ArrayDeque<>();

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			String opr = st.nextToken();

			if(opr.equals("push_front")){
				dq.offerFirst(Integer.parseInt(st.nextToken()));
			} else if(opr.equals("push_back")){
				dq.offerLast(Integer.parseInt(st.nextToken()));
			} else if(opr.equals("pop_front")){
				if(dq.isEmpty()) System.out.println(-1);
				else System.out.println(dq.pollFirst());
			} else if(opr.equals("pop_back")){
				if(dq.isEmpty()) System.out.println(-1);
				else System.out.println(dq.pollLast());
			} else if(opr.equals("size")){
				System.out.println(dq.size());
			} else if(opr.equals("empty")){
				if(dq.isEmpty()) System.out.println(1);
				else System.out.println(0);
			} else if(opr.equals("front")){
				if(dq.isEmpty()) System.out.println(-1);
				else System.out.println(dq.peekFirst());
			} else if(opr.equals("back")){
				if(dq.isEmpty()) System.out.println(-1);
				else System.out.println(dq.peekLast());
			}
		}
	}
}