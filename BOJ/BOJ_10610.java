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
		} // 0�� ������ 30�� ����� �� �� ����
		// �׸��� �� �ڸ����� ���� 3�� ����� �ƴϸ� 30�� ����� �� �� ����
		
		Arrays.sort(tmp);
		StringBuilder sb = new StringBuilder();
		for(int i=tmp.length-1; i>=0; i--) {
			sb.append(tmp[i]);
		}
		
		System.out.println(sb);
	}
}
