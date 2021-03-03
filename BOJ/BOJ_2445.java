package BOJ;

import java.util.*;

public class BOJ_2445 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		for(int i=0; i<n*2-1; i++) {
			StringBuilder sb = new StringBuilder();
			for(int j=0; j<n*2; j++) {
				if(i<n) {
					if(j<=i || j>=n*2-i-1) sb.append("*");
					else sb.append(" ");
				} else {
					if(j<n*2-i-1 || j>i) sb.append("*");
					else sb.append(" ");
				}
			}
			
			System.out.println(sb);
		}
	}
}
