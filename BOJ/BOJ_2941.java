package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2941 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split("");
		
		int count = 0;
		
		for(int i=0; i<str.length; i++) {
			String ch = str[i];
			count++;
			if(isCheck(ch, i, str.length)) {
				String tmp = str[i] + str[i+1];
				if(tmp.equals("c=") || tmp.equals("c-") ||
						tmp.equals("d-") || tmp.equals("lj") ||
						tmp.equals("nj") || tmp.equals("s=") ||
						tmp.equals("z=") || tmp.equals("dz")) {
					if(tmp.equals("dz")) {
						if(i+2 < str.length) {
							if(str[i+2].equals("=")){
								i+=2;
								continue;
							} else continue;
						} else continue;
					}
					i++;
				}
			}
		}
		
		System.out.println(count);
		
	}
	
	public static boolean isCheck(String str, int idx, int len) {
		if((idx+1) < len) {
			if(str.equals("c") || str.equals("d") ||
					str.equals("l") || str.equals("n") ||
					str.equals("s") || str.equals("z")) {
				return true;
			}
		}
		
		return false;
	}
}
