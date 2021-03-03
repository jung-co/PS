package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_11662 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		double ax = Double.parseDouble(st.nextToken());
		double ay = Double.parseDouble(st.nextToken());
		double bx = Double.parseDouble(st.nextToken());
		double by = Double.parseDouble(st.nextToken());
		double cx = Double.parseDouble(st.nextToken());
		double cy = Double.parseDouble(st.nextToken());
		double dx = Double.parseDouble(st.nextToken());
		double dy = Double.parseDouble(st.nextToken());
		
		int inter = 1000000;
		
		double abx = (bx - ax)/inter;
		double aby = (by - ay)/inter;
		double cdx = (dx - cx)/inter;
		double cdy = (dy - cy)/inter;
		
		/*
		 * 
		 *  일반 방법
		 *  
		double min = dist(ax, cx, ay, cy);
		for(int i=1; i<=inter; i++) {
			double tmp = dist(ax+abx*i, cx+cdx*i, ay+aby*i, cy+cdy*i);
			
			if(tmp < min) {
				min = tmp;
			}
		}
		*/
		
		int lo = 0;
		int hi = inter;
		
		while(hi - lo >= 3) {
			int p = (2*lo+hi)/3;
			int q = (lo+hi*2)/3;
			
			double pval = dist(ax+abx*p, cx+cdx*p, ay+aby*p, cy+cdy*p);
			double qval = dist(ax+abx*q, cx+cdx*q, ay+aby*q, cy+cdy*q);
			
			if(pval<qval) {
				hi = q-1;
			} else {
				lo = p+1;
			}
		}
		
		double min = dist(ax+abx*hi, cx+cdx*hi, ay+aby*hi, cy+cdy*hi);
		for(int i=lo; i<hi; i++) {
			double tmp = dist(ax+abx*i, cx+cdx*i, ay+aby*i, cy+cdy*i);
			
			if(tmp < min) min = tmp;			
		}
		
		System.out.println(min);
	}
	
	public static double dist(double x1, double x2, double y1, double y2) {
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2-y1, 2));
	}
}
