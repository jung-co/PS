package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_1712 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken()); // 고정 비용
		int b = Integer.parseInt(st.nextToken()); // 가변 비용
		int c = Integer.parseInt(st.nextToken()); // 판매 비용
		
		if(c <= b)
			System.out.println("-1");
		else
			System.out.println((a/(c-b))+1);
	}
}
