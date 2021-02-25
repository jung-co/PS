package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_1476 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int e = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int er = 1, sr = 1, mr = 1;
		for(int idx=1; ; idx++){
			
			if(er==e && sr==s && mr==m) {
				System.out.println(idx);
				break;
			}
			
			er++;
			sr++;
			mr++;
			
			if(er == 16) er = 1;
			if(sr == 29) sr = 1;
			if(mr == 20) mr = 1;

		}
		
	}
}
