package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_17143 {
	static int row, col, m;
	static int count = 0;

	static int[][] map;
	static ArrayList<Shark> shark = new ArrayList<>();

	static int UP = 1;
	static int DOWN = 2;
	static int RIGHT = 3;
	static int LEFT = 4;

	public static class Shark {
		int r, c, s, d, z;

		public Shark (int r, int c, int s, int d, int z){
			this.r = r; // 행
			this.c = c; // 열
			this.s = s; // 속력
			this.d = d; // 이동 방향
			this.z = z; // 크기
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new int[row][col];

		m = Integer.parseInt(st.nextToken());
		for(int i=0; i<m; i++){
			st = new StringTokenizer(br.readLine());

			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			shark.add(new Shark(r-1, c-1, s, d, z));
			map[r-1][c-1] = shark.size(); // 상어의 인덱스 저장
		}

		for(int i=0; i<col; i++){
			// 낚시왕 이동
			movePerson(i);

			// 상어 이동
			moveShark();
		}

		System.out.println(count);
	}

	public static void movePerson(int idx){
		for(int i=0; i<row; i++){
			if(map[i][idx] != 0){
				Shark cur = shark.get(map[i][idx]-1);

				cur.r = -1;
				cur.c = -1;

				map[i][idx] = 0;
				count += cur.z;
				break;
			}
		}
	}

	public static void moveShark(){
		for(int i=0; i<shark.size(); i++){
			Shark cur = shark.get(i);

			// 이미 잡아먹힌 상어
			if(cur.r == -1 || cur.c == -1){
				continue;
			}

			map[cur.r][cur.c] = 0;

			int dir = 1;
			if(cur.d == RIGHT){
				if(cur.c == col-1){
					changeDir(cur.d);
					dir *= -1;
				}

				for(int j=0; j<cur.s; j++){
					cur.c += dir;
					if(cur.c == 0 || cur.c == col-1){
						cur.d = changeDir(cur.d);
						dir *= -1;
					}
				}
			} else if(cur.d == LEFT){
				dir = -1;

				if(cur.c == 0){
					changeDir(cur.d);
					dir *= -1;
				}
				for(int j=0; j<cur.s; j++){
					cur.c += dir;
					if(cur.c == 0 || cur.c == col-1){
						cur.d = changeDir(cur.d);
						dir *= -1;
					}
				}
			} else if(cur.d == UP){
				dir = -1;

				if(cur.r == 0){
					changeDir(cur.d);
					dir *= -1;
				}
				for(int j=0; j<cur.s; j++){
					cur.r += dir;
					if(cur.r == 0 || cur.r == row-1){
						cur.d = changeDir(cur.d);
						dir *= -1;
					}
				}
			} else if(cur.d == DOWN){
				dir = 1;

				if(cur.r == row-1){
					changeDir(cur.d);
					dir *= -1;
				}
				for(int j=0; j<cur.s; j++){
					cur.r += dir;
					if(cur.r == 0 || cur.r == row-1){
						cur.d = changeDir(cur.d);
						dir *= -1;
					}
				}
			}

			// 잡아 먹자 !
			if(map[cur.r][cur.c] == 0){
				map[cur.r][cur.c] = i+1;
			} else {
				Shark big = shark.get(map[cur.r][cur.c]-1);
				if(big.z > cur.z){
					cur.r = -1;
					cur.c = -1;
				} else {
					map[cur.r][cur.c] = i+1;
				}
			}
		}
	}

	public static int changeDir(int dir){
		if(dir == LEFT){
			dir = RIGHT;
		} else if(dir == RIGHT){
			dir = LEFT;
		} else if(dir == UP){
			dir = DOWN;
		} else if(dir == DOWN){
			dir = UP;
		}

		return dir;
	}
}
