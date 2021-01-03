package BOJ;

import java.util.*;

public class BOJ_1193 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		
		int idx = 1;
		for(int i=1; ; i++) {
			idx += i;
			if(x>=idx && x<=idx+i) {
				
				break;
			}
		}
	}
}
