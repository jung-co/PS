package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_6603 {
	static int k;
	static int[] arr;
	static boolean[] visited;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			
			if(k==0) break;
			
			arr = new int[k];
			visited = new boolean[k];
			for(int i=0; i<k; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			int[] list = new int[7];
			DFS(0, 0, list);
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static void DFS(int idx, int depth, int[] list) {
		if(depth == 6) {
			for(int i=0; i<5; i++) {
				sb.append(list[i]).append(' ');
			}
			sb.append(list[5]).append('\n');
			return;
		}
		
		for(int i=idx; i<k; i++) {
			if(!visited[i]) {
				visited[i] = true;
				list[depth] = arr[i];
				DFS(i, depth+1, list);
				visited[i] = false;
				list[depth] = 0;
			}
		}
	}
}
