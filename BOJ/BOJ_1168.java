package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_1168 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken()) - 1;
		
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			list.add(i+1);
		}
		
		sb.append("<");
		for(int i=k; list.size() > 1; i+=k) {
			if(i >= list.size()) {
				i %= list.size();
			}
			
			if(!list.isEmpty()) {
				sb.append(list.remove(i) + ", ");
			}
		} sb.append(list.remove(0) + ">");
		
		bw.write(sb.toString());
		bw.flush();
	}
}
