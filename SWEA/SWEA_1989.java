package SWEA;

import java.util.*;
import java.io.*;

public class SWEA_1989 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=test_case; t++) {
			String str = br.readLine();
			int len = str.length()-1;
			
			int check = 1;
			for(int i=0; i<len/2; i++) {
				char[] tmp = {str.charAt(i), str.charAt(len-i)};
				if(tmp[0] != tmp[1]) {
					check = 0;
					break;
				}
			}
			
			System.out.format("#%d %d\n", t, check);
		}
	}
}
