package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_9663 {
	static int n;
	static int count = 0;
	
	static boolean[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr = new boolean[n][n];
		nQueen(0);
		
		System.out.println(count);
	}
	
	public static void nQueen(int size) {
		if(size == n) {
			count++;
			return;
		}
		
		for(int i=0; i<n; i++) {
			arr[size][i] = true;
			if(isCheck(size, i)) nQueen(size+1);
			arr[size][i] = false;
		}
	}
	
	public static boolean isCheck(int sz, int idx) {
		for(int i=0; i<sz; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j]) {
					if(j==idx)  return false;
					if(Math.abs(i-sz) == Math.abs(j-idx)) return false;
				}
			}
		}
		
		return true;
	}
		
		/*
		arr = new int[n];
		nQueen(0);
		
		System.out.println(count);
	}
	
	public static void nQueen(int size) {
		if(size == n) {
			count++;
			return;
		}
		
		for(int i=0; i<n; i++) {
			arr[size] = i;
			if(isCheck(size)) {
				nQueen(size+1);
			}
		}
	}
	
	public static boolean isCheck(int idx) {
		for(int i=0; i<idx; i++) {
			if(arr[idx] == arr[i])
				return false;
			else if(Math.abs(idx - i) == Math.abs(arr[idx] - arr[i]))
				return false;
		}
		
		return true;
	}
	*/
}
