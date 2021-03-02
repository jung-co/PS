package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_1931 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		int[][] list = new int[n][2];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			list[i][0] = start;
			list[i][1] = end;
		}
		
		Arrays.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// 종료시간이 같을 경우 시작시간이 빠른 순으로 정렬
				return o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1];
			}
		});
		
		int count = 0;
		int prev_end_time = 0;
		for(int i=0; i<n; i++) {
			if(prev_end_time <= list[i][0]) {
				prev_end_time = list[i][1];
				count++;
			}
		}
		
		System.out.println(count);
	}
}
