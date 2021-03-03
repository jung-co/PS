package SWEA;

import java.util.*;
import java.io.*;

public class SWEA_1288 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=t; test_case++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#" + test_case + " ");
			
			ArrayList<Character> arr = new ArrayList<>();
			int n = Integer.parseInt(br.readLine());
			int count = 0;
			for(int i=1; ; i++) {
				count++;
				
				int tmp = n * i;
				char[] str = Integer.toString(tmp).toCharArray();
				
				for(int j=0; j<str.length; j++) {
					if(!arr.contains(str[j]))
						arr.add(str[j]);
				}
				
				if(arr.size() >= 10)
					break;
			}
			
			sb.append(count * n);
			System.out.println(sb);
		}
	}
}
