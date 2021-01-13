package SWEA;

import java.util.*;
import java.io.*;

public class SWEA_1974 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=test_case; t++) {
			int[][] sudoku = new int[9][9];
			StringTokenizer st;
			
			for(int i=0; i<9; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<9; j++) {
					sudoku[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int result = isCheck(sudoku);
			
			System.out.println("#" + t + " " + result);
		}
	}
	
	public static int isCheck(int[][] sudoku) {
		for(int i=0; i<9; i++) {
			int[] arr = new int[9];
			for(int j=0; j<9; j++) {
				int tmp = sudoku[i][j];
				
				if(arr[tmp-1] == 0) arr[tmp-1]++;
				else return 0;
			}
		}
		
		for(int i=0; i<9; i++) {
			int[] arr = new int[9];
			for(int j=0; j<9; j++) {
				int tmp = sudoku[j][i];
				
				if(arr[tmp-1] == 0) arr[tmp-1]++;
				else return 0;
			}
		}
		
		for(int i=0; i<9; i+=3) {
			for(int j=0; j<9; j+=3) {
				int[] arr = new int[9];
				for(int k=i; k<i+3; k++) {
					for(int l=j; l<j+3; l++) {
						int tmp = sudoku[k][l];
						
						if(arr[tmp-1] == 0) arr[tmp-1]++;
						else return 0;
					}
				}
			}
		}
		
		return 1;
	}
}
