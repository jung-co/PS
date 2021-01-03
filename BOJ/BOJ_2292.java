package BOJ;

import java.util.*;

public class BOJ_2292 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 1;
		
		if(n != 1) {
			int idx = 2;
			for(int i=1; ; i++) {
				count++;
				
				int mul = i*6;
				if(n >= idx && n < idx + mul) {
					break;
				} idx += mul;
			}
		} System.out.println(count);
	}
}
