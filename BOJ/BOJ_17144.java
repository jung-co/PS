package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17144 {
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};

	static int r, c, t;
	static int[][] map;
	static int cleaner = -1;

	static Queue<Dust> dust = new LinkedList<>();

	public static class Dust {
		int x, y;
		int value;

		public Dust(int x, int y, int value){
			this.x = x;
			this.y = y;
			this.value = value;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		map = new int[r][c];

		for(int i=0; i<r; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<c; j++){
				map[i][j] = Integer.parseInt(st.nextToken());

				if(cleaner == -1 && map[i][j] == -1){
					cleaner = i;
				}
			}
		}

		for(int i=0; i<t; i++){
			checkDust();
			diffusion();
			cleaner();
		}

		int size = 0;
		for(int i=0; i<r; i++){
			for(int j=0; j<c; j++){
				if(map[i][j] > 0) size += map[i][j];
			}
		}

		System.out.println(size);
	}

	public static void checkDust(){
		dust = new LinkedList<>();
		for(int i=0; i<r; i++){
			for(int j=0; j<c; j++){
				if(map[i][j] > 0){
					dust.offer(new Dust(i ,j ,map[i][j]));
				}
			}
		}
	}

	public static void diffusion(){
		while(!dust.isEmpty()){
			Dust now = dust.poll();
			if(now.value < 5) continue;

			int cnt = 0;
			int diffVal = (int)(now.value/5);
			for(int i=0; i<4; i++){
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if(nx<0 || ny<0 || nx>=r || ny>=c) continue;
				if(map[nx][ny] == -1) continue;

				map[nx][ny] += diffVal;
				cnt++;
			}

			map[now.x][now.y] -= diffVal * cnt;
		}
	}

	public static void cleaner(){
		int top = cleaner;
		int bottom = cleaner + 1;

		for(int i=top-1; i>0; i--){
			map[i][0] = map[i-1][0];
		}
		for(int i=0; i<c-1; i++){
			map[0][i] = map[0][i+1];
		}
		for(int i=0; i<top; i++){
			map[i][c-1] = map[i+1][c-1];
		}
		for(int i=c-1; i>1; i--){
			map[top][i] = map[top][i-1];
		}
		map[top][1] = 0;

		for(int i=bottom+1; i<r-1; i++){
			map[i][0] = map[i+1][0];
		}
		for(int i=0; i<c-1; i++){
			map[r-1][i] = map[r-1][i+1];
		}
		for(int i=r-1; i>bottom; i--){
			map[i][c-1] = map[i-1][c-1];
		}
		for(int i=c-1; i>1; i--){
			map[bottom][i] = map[bottom][i-1];
		}
		map[bottom][1] = 0;
	}
}
