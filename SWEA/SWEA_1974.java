package SWEA;

import java.util.*;
import java.io.*;

public class SWEA_1974 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());
		boolean[] check;
		
		for(int t=1; t<=test_case; t++) {
			int[][] sudoku = new int[9][9];
			boolean flag = true;
			
			for(int i=0; i<9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				check = new boolean[9];
				for(int j=0; j<9; j++) {
					sudoku[i][j] = Integer.parseInt(st.nextToken());
					if(!check[sudoku[i][j]-1]) {
						check[sudoku[i][j]-1] = true;
					} else {
						flag = false;
					}
				}
			} if(!flag) {
				System.out.format("#%d 0\n", t);
				continue;
			}
			
			check = new boolean[9];
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					if(!check[sudoku[j][i]-1])
						check[sudoku[j][i]-1] = true;
					else
						flag = false;
				}
			} if(!flag) {
				System.out.format("#%d 0\n", t);
				continue;
			}
			
			check = new boolean[9];
			for(int i=0; i<9; i+=3) {
				for(int j=0; j<9; j+=3) {
					for(int k=0; k<3; k++) {
						if(!check[sudoku[i+k][j+k]-1])
							check[sudoku[i+k][j+k]-1] = true;
						else
							flag = false;
					}
				}
			} if(!flag) {
				System.out.format("#%d 0\n", t);
				continue;
			}
			
			System.out.format("#%d 1\n", t);
		}
	}
}
