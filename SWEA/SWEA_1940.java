package SWEA;

import java.util.*;
import java.io.*;

public class SWEA_1940 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=t; test_case++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#" + test_case + " ");
			
			int speed = 0;
			int dist = 0;
			int n = Integer.parseInt(br.readLine());
			for(int i=1; i<=n; i++) {
				st = new StringTokenizer(br.readLine());
				
				int m, s;
				m = Integer.parseInt(st.nextToken());
				if(m > 0) {
					s = Integer.parseInt(st.nextToken());
					if(m == 1) speed += s;
					else {
						speed -= s;
						if(speed < 0) {
							speed = 0;
						}
					}
					
				}
				
				dist += speed;
			}
			
			sb.append(dist);
			System.out.println(sb);
		}
	}
}
