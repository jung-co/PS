package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_2580 {
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new int[9][9];
		for(int i=0; i<9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		sudoku(0, 0);
	}
	
	public static void sudoku(int row, int col) {
		if(col == 9) {
			sudoku(row+1, 0);
			return;
		}
		
		if(row == 9) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					sb.append(map[i][j]).append(' ');
				}
				sb.append('\n');
			}
			System.out.println(sb);
			System.exit(0);
		}
		
		if(map[row][col] == 0) {
			for(int i=1; i<=9; i++) {
				if(possible(row, col, i)) {
					map[row][col] = i;
					sudoku(row, col+1);
				}
			}
			
			map[row][col] = 0;
			return;
		}
		
		sudoku(row, col+1);
	}
	
	public static boolean possible(int row, int col, int val) {
		for(int i=0; i<9; i++) {
			if(map[row][i] == val) {
				return false;
			}
		}
		
		for(int i=0; i<9; i++) {
			if(map[i][col] == val) {
				return false;
			}
		}
		
		int set_row = (row/3)*3;
		int set_col = (col/3)*3;
		
		for(int i=set_row; i<set_row+3; i++) {
			for(int j=set_col; j<set_col+3; j++) {
				if(map[i][j] == val) {
					return false;
				}
			}
		}
		
		return true;
	}
}
