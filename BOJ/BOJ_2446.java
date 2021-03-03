package BOJ;

import java.util.*;

public class BOJ_2446 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		for(int i=0; i<n*2-1; i++) {
			StringBuilder sb = new StringBuilder();
			if(i<n) {
				for(int j=0; j<n*2-i-1; j++) {
					if(j<i) sb.append(" ");
					else sb.append("*");
				}
			} else {
				for(int j=0; j<=i; j++) {
					if(j<n*2-i-2) sb.append(" ");
					else sb.append("*");
				}
			}

			
			System.out.println(sb);
		}
	}
}
