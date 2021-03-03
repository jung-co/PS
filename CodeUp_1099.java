import java.util.*;
import java.io.*;

public class CodeUp_1099 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int[][] map =  new int[10][10];
		for(int i=0; i<10; i++) {
			String[] tmp = br.readLine().split(" ");
			for(int j=0; j<10; j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		
		int idx_x = 1;
		int idx_y = 1;
		while(map[idx_x][idx_y] != 2) {
			map[idx_x][idx_y] = 9;
			if(map[idx_x][idx_y+1] != 1)
				idx_y++;
			else if(map[idx_x+1][idx_y] != 1)
				idx_x++;
			else break;
		} map[idx_x][idx_y] = 9;

		/*
		if(idx_x == 8 && idx_y == 8)
			break;
		
		if(map[idx_x][idx_y+1] == 0) {
			map[idx_x][++idx_y] = 9;
			continue;
		} else if(map[idx_x][idx_y+1] == 2) {
			map[idx_x][++idx_y] = 9;
			break;
		}
		if(map[idx_x+1][idx_y] == 0) {
			map[++idx_x][idx_y] = 9;
		} else if(map[idx_x+1][idx_y] == 1){
			break;
		} else {
			map[++idx_x][idx_y] = 9;
			break;
		}
		
	}*/
	
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				sb.append(map[i][j] + " ");
			} sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
