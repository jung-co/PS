package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_21608 {
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};

	static int n;
	static int[][] map;

	static ArrayList<Integer>[] like;
	static Queue<Student> student;

	public static class Student {
		int idx, x, y;

		Student(int idx, int x, int y){
			this.idx = idx;
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];

		like = new ArrayList[n*2+1];
		student = new LinkedList<>();

		StringTokenizer st;
		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			like[n] = new ArrayList<>();
			student.offer(new Student(n, -1, -1));

			for(int j=0; j<4; j++){
				like[n].add(Integer.parseInt(st.nextToken()));
			}
		}


	}
}
