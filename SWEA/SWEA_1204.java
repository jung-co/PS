package SWEA;

import java.util.*;
import java.io.*;

public class SWEA_1204 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			int test_case = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			int idx = 0;
			int max = -1;
			int[] score = new int[101];
			while(st.hasMoreTokens()) {
				int tmp = Integer.parseInt(st.nextToken());
				
				score[tmp]++;
				if(score[tmp] > max) {
					max = score[tmp];
					idx = tmp;
				} else if(score[tmp] == max && tmp > idx) {
					idx = tmp;
				}
			}
			
			System.out.println("#" + test_case + " " + idx);
		}
	}
}
