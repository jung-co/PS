package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_16173 {
    class Dot {
        int x, y;
        int dir;

        Dot (int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];

		for(int i=0; i<n; i++){
		    st = new StringTokenizer(br.readLine());
		    for(int j=0; j<n; j++){
		        map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[n][n];

		q.offer(new int[] {0, 0});
		visited[0][0] = true;


		
        System.out.println(Math.ceil(-1.0 / -2));
    }
}
