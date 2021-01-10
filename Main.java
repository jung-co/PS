import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; // = new StringTokenizer(br.readLine());
		
		//String a = st.nextToken();
		//Long h = Long.parseLong(st.nextToken());
		//long a = Integer.parseInt(st.nextToken());
		//int a = Integer.parseInt(br.readLine());
		//int b = Integer.parseInt(st.nextToken());
		//int c = Integer.parseInt(st.nextToken());
		int[][] map = new int[20][20];
		
		for(int i=1; i<20; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=1; j<20; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int j=1; j<20; j++) {
				if(map[x][j] == 0) map[x][j] = 1;
				else map[x][j] = 0;
			}
			
			for(int j=1; j<20; j++) {
				if(map[j][y] == 0) map[j][y] = 1;
				else map[j][y] = 0;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<19; i++) {
			for(int j=1; j<19; j++) {
				sb.append(map[i][j] + " ");
			} sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
