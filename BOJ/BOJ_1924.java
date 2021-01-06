package BOJ;

import java.util.Scanner;

public class BOJ_1924 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] day = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		String[] week = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		
		int x = sc.nextInt();
		int y = sc.nextInt();

		int total = y;
		for(int i=1; i<x; i++) {
			total += day[i];
		}
		
		System.out.println(week[total%7]);
	}
}
