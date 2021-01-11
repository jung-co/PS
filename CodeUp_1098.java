import java.util.*;
import java.io.*;

public class CodeUp_1098 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		//String a = st.nextToken();
		//Long h = Long.parseLong(st.nextToken());
		//long a = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int[][] sugar = new int[h][w];
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int l = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			
			if(d==0) {
				for(int j=y; j<y+l; j++) {
					sugar[x][j] = 1;
				}
			} else {
				for(int j=x; j<x+l; j++) {
					sugar[j][y] = 1;
				}
			}
		}
		
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				sb.append(sugar[i][j] + " ");
			} sb.append("\n");
		}
		System.out.println(sb);
	}
}
