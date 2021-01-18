package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_16236 {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int n;
	static int[][] map;
	static int[][] dist;
	
	static Shark shark;
	static Shark min;
	static int min_dist;
	static int size = 2;
	
	public static class Shark {
		int x, y;
		
		public Shark (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];
		dist = new int[n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 9) {
					shark = new Shark(i, j);
					map[i][j] = 0;
				}
			}
		}
		
		int result = 0;
		int eat = 0;
		while(true) {
			min_dist = Integer.MAX_VALUE;
			min = new Shark(Integer.MAX_VALUE, Integer.MAX_VALUE);
			for(int i=1; i<=n; i++) {
				Arrays.fill(dist[i], -1);
			}
			
			BFS(shark.x, shark.y);
			
			if(min.x != Integer.MAX_VALUE && min.y != Integer.MAX_VALUE) {
				result += dist[min.x][min.y];
				eat++;
				
				if(eat == size) {
					size ++;
					eat = 0;
				}
				
				map[min.x][min.y]= 0;
				
				shark.x = min.x;
				shark.y = min.y;
			} else {
				break;
			}
		}
		
		System.out.println(result);
	}
	
	public static void BFS(int x, int y) {
		Queue<Shark> q = new LinkedList<>();
		q.offer(new Shark(x, y));
		dist[x][y] = 0;
		
		while(!q.isEmpty()) {
			Shark loc = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = loc.x + dx[i];
				int ny = loc.y + dy[i];
				
				if(isCheck(nx, ny) && dist[nx][ny] == -1 && map[nx][ny] <= size) {
					dist[nx][ny] = dist[loc.x][loc.y] + 1;
					
					if(map[nx][ny] != 0 && map[nx][ny] < size) {
						if(min_dist > dist[nx][ny]) {
							min.x = nx;
							min.y = ny;
							min_dist = dist[nx][ny];
						} else if(min_dist == dist[nx][ny]) {
							if(min.x == nx) {
								if(min.y > ny) {
									min.x = nx;
									min.y = ny;
								}
							} else if(min.x > nx) {
								min.x = nx;
								min.y = ny;
							}
						}
					}
					
					q.offer(new Shark(nx, ny));
				}
			}
		}
	}
	
	public static boolean isCheck(int x, int y) {
		return x>=0 && y>=0 && x<n && y<n;
	}
}
