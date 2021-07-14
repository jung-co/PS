package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_15683 {
	static int n, m, zero = 0;
	static int monitorCount = Integer.MAX_VALUE;

	static int[] dx = {0, 0, 1, -1}; // 동 서 남 북
	static int[] dy = {1, -1, 0, 0};
	
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<CCTV> arr = new ArrayList<>();

	public static class CCTV {
		int x, y, num;
		ArrayList<Integer> directions = new ArrayList<>();

		CCTV(int x, int y, int num){
			this.x = x;
			this.y = y;
			this.num = num;
		}

		public void addDirection(int dir){
			directions.add(dir);
		}

		public int DirectionSize() {
			return directions.size();
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		visited = new boolean[n][m];

		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0){
					zero++;
				} else if(map[i][j] != 6){
					arr.add(new CCTV(i, j, map[i][j]));
				}
			}
		}
	}

	public static void DFS(int idx, int size, CCTV[] selectedCctv){
		if(idx == size){
			countArea(selectedCctv, new boolean[n][m]);
		} else {
			CCTV selectCctv = arr.get(idx);
			for(int i=0; i<4; i++){
				CCTV c = new CCTV(selectCctv.x, selectCctv.y, selectCctv.num);
				switch(selectCctv.num){
					case 1:
						c.addDirection(i);
						selectedCctv[idx] = c;
						DFS(idx+1, size, selectedCctv);
						break;
					case 2:
						if(i >= 2) {	// 2가지 경우의 수 밖에 없으므로
							return;
						}
						c.addDirection(i);
						c.addDirection(i + 2);
						selectedCctv[idx] = c;
						DFS(idx + 1, size, selectedCctv);
						break;
					case 3:
						c.addDirection(i);
						c.addDirection((i + 1) % 4);
						selectedCctv[idx] = c;
						DFS(idx + 1, size, selectedCctv);
						break;
					case 4:
						c.addDirection(i);
						c.addDirection((i + 1) % 4);
						c.addDirection((i + 2) % 4);
						selectedCctv[idx] = c;
						DFS(idx + 1, size, selectedCctv);
						break;
					case 5:
						if(i >= 1) {	// 1가지 경우의 수 밖에 없으므로
							return;
						}
						c.addDirection(i);
						c.addDirection((i + 1) % 4);
						c.addDirection((i + 2) % 4);
						c.addDirection((i + 3) % 4);
						selectedCctv[idx] = c;
						DFS(idx + 1, size, selectedCctv);
						break;
				}
			}
		}
	}

	// 사각지대 개수 검사
	public static void countArea(CCTV[] selectedCctv, boolean[][] visited) {
		int count = 0;
		for(int i = 0; i < selectedCctv.length; i++) {
			CCTV c = selectedCctv[i];
			// 방향별로 쭉 검사
			for(int d = 0; d < c.DirectionSize(); d++) {
				int direction = c.directions.get(d);
				int nextX = c.x + dx[direction];
				int nextY = c.y + dy[direction];
				while((nextX >= 0 && nextX < n) && (nextY >= 0 && nextY < m)) {
					if(map[nextY][nextX] == 0) {
						if(!visited[nextY][nextX]) {
							count++;
							visited[nextY][nextX] = true;
						}
					}
					else if(map[nextY][nextX] == 6) {
						break;
					}
					nextX += dx[direction];
					nextY += dy[direction];
				}
			}
		}
		monitorCount = Math.min(monitorCount, zero - count);
	}
}
