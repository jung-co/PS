package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_14888 {
	static int[] oper = new int[4];
	static int[] num;
	
	static int n;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		num = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; st.hasMoreTokens(); i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}
		
		DFS(num[0], 1);
		
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void DFS(int num_val, int num_idx) {
		if(num_idx == n) {
			max = Math.max(max, num_val);
			min = Math.min(min, num_val);
			
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(oper[i] > 0) {
				oper[i]--;
				
				if(i == 0) {
					DFS(num_val+num[num_idx], num_idx+1);
				} else if(i == 1) {
					DFS(num_val-num[num_idx], num_idx+1);
				} else if(i == 2) {
					DFS(num_val*num[num_idx], num_idx+1);
				} else {
					DFS(num_val/num[num_idx], num_idx+1);
				}
				
				oper[i]++;
			}
		}
	}
}
