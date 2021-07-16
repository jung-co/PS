package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234 {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	static int n, l, r;
	static int[][] map;
	static boolean[][] visited;

	static int day = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		if(n == 1){
			System.out.println(0);
			return;
		}

		while(true){
			visited = new boolean[n][n];
			boolean flag = false;

			// 인구이동이 이뤄져야 하는 군 찾기
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					if(!visited[i][j]){
						if(move(i, j)){
							flag = true;
						}
					}
				}
			}

			if(flag){
				day++;
			} else {
				break;
			}
		}

		System.out.println(day);
	}

	public static boolean move(int x, int y){
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		visited[x][y] = true;

		int cnt = 1;
		int totalCount = map[x][y];

		Queue<int[]> arr = new LinkedList<>();
		arr.offer(new int[] {x, y});

		while(!q.isEmpty()){
			int[] now = q.poll();

			for(int i=0; i<4; i++){
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];

				if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
				if(visited[nx][ny]) continue;

				int tmp = Math.abs(map[nx][ny] - map[now[0]][now[1]]);
				if(tmp >= l && tmp <= r){
					visited[nx][ny] = true;

					q.offer(new int[] {nx, ny});
					arr.offer(new int[] {nx, ny});

					totalCount += map[nx][ny];
					cnt++;
				}
			}
		}

		if(cnt > 1) {
			people(arr, totalCount, cnt);
			return true;
		}

		return false;
	}

	public static void people(Queue<int[]> q, int totalCount, int cnt){
		int avg = (int)(totalCount/cnt);

		while(!q.isEmpty()){
			int[] now = q.poll();
			map[now[0]][now[1]] = avg;
		}
	}
}
