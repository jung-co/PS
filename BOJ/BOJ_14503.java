package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14503 {
	static int n, m, cnt = 1;

	static int[][] map;

	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {-1, 0, 1, 0};

	static class Dot {
		int x, y, dir;

		public Dot(int x, int y, int now){
			this.x = x;
			this.y = y;
			this.dir = now;
		}

		public void rotation(){
			if(dir == 0){
				dir = 3;
			} else if(dir == 1){
				dir = 0;
			} else if(dir == 2){
				dir = 1;
			} else {
				dir = 2;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int robotX = Integer.parseInt(st.nextToken());
		int robotY = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		BFS(robotX, robotY, dir);
		System.out.println(cnt);
	}

	public static void BFS(int x, int y, int dir){
		Queue<Dot> q = new LinkedList<>();
		q.offer(new Dot(x, y, dir));
		map[x][y] = 2;

		while(!q.isEmpty()){
			Dot now = q.poll();

			int nx, ny;
			boolean flag = false;

			for(int i=0; i<4; i++){
				nx = now.x + dx[now.dir];
				ny = now.y + dy[now.dir];

				if(nx<0 || ny<0 || nx>=n || ny>=m){
					continue;
				}

				now.rotation();
				if(map[nx][ny] == 0){
					q.offer(new Dot(nx, ny, now.dir));
					map[nx][ny] = 2;
					flag = true;
					cnt++;
					break;
				}
			}

			if(!flag){
				if(now.dir == 0){
					nx = now.x + 1;
					ny = now.y;
				} else if(now.dir == 1){
					nx = now.x;
					ny = now.y - 1;
				} else if(now.dir == 2){
					nx = now.x - 1;
					ny = now.y;
				} else {
					nx = now.x;
					ny = now.y + 1;
				}

				if(map[nx][ny] != 1){
					if(map[nx][ny] != 2){
						cnt++;
					}
					map[nx][ny] = 2;
					q.offer(new Dot(nx, ny, now.dir));
				}
			}
		}
	}
}

//https://zoonvivor.tistory.com/130
