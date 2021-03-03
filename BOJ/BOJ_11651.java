package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_11651 {
	public static class Point {
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Point[] point = new Point[n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			point[i] = new Point(x, y);
		}
		
		Arrays.sort(point, new Comparator<Point>(){
			@Override
			public int compare(Point p1, Point p2) {
				if(p1.y != p2.y) return p1.y - p2.y;
				else return p1.x - p2.x;
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			sb.append(point[i].x + " " + point[i].y + "\n");
		}
		
		System.out.println(sb);
	}
}
