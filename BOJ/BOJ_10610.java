package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_10610 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] tmp = br.readLine().toCharArray();
		
		int sum = 0;
		boolean check = false;
		for(int i=0; i<tmp.length; i++) {
			int n = tmp[i] - '0';
			sum += n;
			
			if(n == 0) check = true;
		}
		
		if(!check || sum%3!=0) {
			System.out.println(-1);
			return;
		} // 0이 없으면 30의 배수가 될 수 없음
		// 그리고 각 자리수의 합이 3의 배수가 아니면 30의 배수가 될 수 없음
		
		Arrays.sort(tmp);
		StringBuilder sb = new StringBuilder();
		for(int i=tmp.length-1; i>=0; i--) {
			sb.append(tmp[i]);
		}
		
		System.out.println(sb);
	}
}
