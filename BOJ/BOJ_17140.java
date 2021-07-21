package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17140 {
	static int r, c, k;
	static int xLength = 3, yLength = 3;
	static int[][] map = new int[101][101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		for(int i=0; i<3; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

	}

	public static int solution(){
		for(int answer=0; answer<=100; answer++){
			if(map[r][c] == k){
				return answer;
			}

			operation();
		}
		return -1;
	}

	static void operation(){
		if(xLength >= yLength){
			for(int i=1; i<=xLength; i++){
				countRow(i);
			}
		} else {
			for(int i=1; i<=yLength; i++){
				countCol(i);
			}
		}
	}

	public static void countRow(int key){

	}

	public static void countCol(int key){
	}
}
