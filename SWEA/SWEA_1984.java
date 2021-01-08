package SWEA;

import java.util.*;
import java.io.*;

public class SWEA_1984 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=test_case; t++) {
			String[] str = br.readLine().split(" ");
			int len = str.length;
			
			int[] list = new int[len];
			for(int i=0; i<len; i++) {
				list[i] = Integer.parseInt(str[i]);
			} Arrays.sort(list);
			
			float sum = 0;
			for(int i=1; i<len-1; i++) {
				sum += list[i];
			}
			
			System.out.format("#%d %d\n", t, Math.round(sum/(len-2)));
		}
	}
}
