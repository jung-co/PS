package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502 {
	static int n, m, max = 0;
	static int[][] map;

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	static class Dot {
		int x, y;

		public Dot(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		DFS(0);
		System.out.println(max);
	}

	static void DFS(int depth){
		if(depth == 3){
			int cnt = BFS();
			max = Math.max(max, cnt);
			return;
		}

		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(map[i][j] == 0){
					map[i][j] = 1;
					DFS(depth + 1);
					map[i][j] = 0;
				}
			}
		}
	}

	public static int BFS(){
		Queue<Dot> q = new LinkedList<>();
		int[][] virus = new int[n][m];
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				virus[i][j] = map[i][j];
			}
		}

		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(virus[i][j] == 2){
					q.offer(new Dot(i, j));
				}
			}
		}

		while(!q.isEmpty()){
			Dot now = q.poll();

			for(int d=0; d<4; d++){
				int nx = now.x + dx[d];
				int ny = now.y + dy[d];

				if(nx>=0 && ny>=0 && nx<n && ny<m){
					if(virus[nx][ny] == 0){
						virus[nx][ny] = 2;
						q.offer(new Dot(nx, ny));
					}
				}
			}
		}

		int cnt = 0;
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(virus[i][j] == 0){
					cnt++;
				}
			}
		}

		return cnt;
	}
}
