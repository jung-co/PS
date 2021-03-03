package SWEA;

import java.util.*;
import java.io.*;

public class SWEA_2007 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=t; test_case++) {
			String pattern = br.readLine();
			
			int len = 0;
			for(int i=1; i<=10; i++) {
				String str = pattern.substring(0, i);
				String tmp = pattern.substring(i, i+i);
				if(str.equals(tmp)) {
					len = str.length();
					break;
				}
			}
			
			System.out.println(len);
		}
	}
}
