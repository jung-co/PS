package SWEA;

import java.util.*;
import java.io.*;

public class SWEA_1970 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		int[] money = {50000,10000,5000,1000,500,100,50,10};
		for(int test_case=1; test_case<=t; test_case++) { 
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append("\n");
			
			int n = Integer.parseInt(br.readLine());
			int[] mon_cnt = new int[money.length];
			
			for(int i=0; i<money.length; i++) {
				int tmp = n / money[i];
				mon_cnt[i] = tmp;
				
				n = n - money[i] * tmp;
			}
			
			for(int i=0; i<money.length; i++) {
				sb.append(mon_cnt[i]).append(" ");
			}
			
			System.out.println(sb);
		}
	}
}