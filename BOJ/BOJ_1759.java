package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_1759 {
	static int l, c;
	static int con=0;
	static int vow=0; // con : 자음, vow : 모음
	
	static boolean[] visited;
	static char[] arr;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new char[c];
		visited = new boolean[c];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<c; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(arr);
		char[] ans = new char[l];
		DFS(-1, 0, ans);
		
		System.out.println(sb);
	}
	
	public static void DFS(int len, int idx, char[] ans) {
		if(len == l-1) {
			if(con<2 || vow<1) return;
			
			for(int i=0; i<l; i++) {
				sb.append(ans[i]);
			} sb.append("\n");
			return;
		}
		
		for(int i=idx; i<c; i++) {
			if(!visited[i]) {
				visited[i] = true;
				ans[len+1] = arr[i];
				
				if(check(arr[i])) {
					vow++;
					DFS(len+1, i, ans);
					vow--;
				} else {
					con++;
					DFS(len+1, i, ans);
					con--;
				}
				
				ans[len+1] = 0;
				visited[i] = false;
			}
		}
	}
	
	public static boolean check(char t) {
		return t == 'a' || t == 'e' || t == 'i' || t == 'o' || t == 'u';
	}
}
