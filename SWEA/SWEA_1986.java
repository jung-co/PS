package SWEA;

import java.util.*;
import java.io.*;

public class SWEA_1986 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=test_case; t++) {
			int n = Integer.parseInt(br.readLine());
			
			int sum = 0;
			for(int i=1; i<=n; i++) {
				if(i%2!=0) sum += i;
				else sum -= i;
			}
			System.out.format("#%d %d\n", t, sum);
		}
	}
}
