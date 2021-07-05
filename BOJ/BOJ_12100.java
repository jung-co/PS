package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12100 {
	static int n, answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		int[][] map = new int[n][n];
		StringTokenizer st;
		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		answer = 0;
		dfs(map, 0);
		System.out.println(answer);
	}

	public static void dfs(int[][] map, int v){
		int max = 0;
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(max < map[i][j])
					max = map[i][j];
			}
		}

		answer = max > answer ? max : answer;

		if(v==5) return;

		for(int i=0; i<4; i++) {
			int[][] tmp = new int[n][n];
			for(int j=0; j<n; j++){
				tmp[j] = map[j].clone();
			}

			rotation(tmp, i);
			dfs(tmp, v+1);
		}
	}

	static void rotation(int[][] map, int idx){
		boolean[][] visited = new boolean[n][n];
		switch(idx){
			case 0: // 상
				for(int i=0; i<n; i++){
					for(int j=0; j<n; j++){
						int di = i;
						while(di-1>=0 && map[di-1][j]==0) di--;

						if(di>0){
							if(map[di-1][j]==map[i][j] && !visited[di-1][j]){
								map[di-1][j] *= 2;
								map[i][j] = 0;
								visited[di-1][j] = true;
							} else {
								int tmp = map[i][j];
								map[i][j] = 0;
								map[di][j] = tmp;
							}
						} else {
							int tmp = map[i][j];
							map[i][j] = 0;
							map[di][j] = tmp;
						}
					}
				}
				break;
			case 1: // 하
				for(int i=n-1; i>=0; i--){
					for(int j=0; j<n; j++){
						int di = i;
						while(di+1<n && map[di+1][j]==0) di++;

						if(di<n-1){
							if(map[di+1][j]==map[i][j] && !visited[di+1][j]){
								map[di+1][j] *= 2;
								map[i][j] = 0;
								visited[di+1][j] = true;
							} else {
								int tmp = map[i][j];
								map[i][j] = 0;
								map[di][j] = tmp;
							}
						} else {
							int tmp = map[i][j];
							map[i][j] = 0;
							map[di][j] = tmp;
						}
					}
				}
				break;
			case 2: // 좌
				for(int j=0; j<n; j++){
					for(int i=0; i<n; i++){
						int dj = j;
						while(dj-1>=0 && map[i][dj-1]==0) dj--;

						if(dj>0){
							if(map[i][dj-1]==map[i][j] && !visited[i][dj-1]){
								map[i][dj-1] *= 2;
								map[i][j] = 0;
								visited[i][dj-1] = true;
							} else {
								int tmp = map[i][j];
								map[i][j] = 0;
								map[i][dj] = tmp;
							}
						} else {
							int tmp = map[i][j];
							map[i][j] = 0;
							map[i][dj] = tmp;
						}
					}
				}
				break;
			case 3: // 우
				for(int j=n-1; j>=0; j--){
					for(int i=0; i<n; i++){
						int dj = j;
						while(dj+1<n && map[i][dj+1]==0) dj++;

						if(dj<n-1){
							if(map[i][dj+1]==map[i][j] && !visited[i][dj+1]){
								map[i][dj+1] *= 2;
								map[i][j] = 0;
								visited[i][dj+1] = true;
							} else {
								int tmp = map[i][j];
								map[i][j] = 0;
								map[i][dj] = tmp;
							}
						} else {
							int tmp = map[i][j];
							map[i][j] = 0;
							map[i][dj] = tmp;
						}
					}
				}
				break;
		}
	}


}
