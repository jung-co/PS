package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_1712 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken()); // ���� ���
		int b = Integer.parseInt(st.nextToken()); // ���� ���
		int c = Integer.parseInt(st.nextToken()); // �Ǹ� ���
		
		if(c <= b)
			System.out.println("-1");
		else
			System.out.println((a/(c-b))+1);
	}
}
