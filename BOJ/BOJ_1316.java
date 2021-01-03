package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_1316 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int count = 0;
		for(int i=0; i<n; i++) {
			ArrayList<Character> arr = new ArrayList<>();
			String str = br.readLine();
			
			for(int j=0; j<str.length(); j++) {
				char ch = str.charAt(j);
				
				if(!arr.contains(ch)) {
					arr.add(ch);
				} else {
					if(arr.get(arr.size()-1) != ch) {
						count--;
						break;
					}
				}
			} count++;
		}
		
		System.out.println(count);
	}
}
