package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_20055 {

	static int n, k, cnt = 0;
	static int containerSize;

	static int[] container;
	static boolean[] robot;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		containerSize = n*2;
		container = new int[containerSize];
		robot = new boolean[n];

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<containerSize; i++){
			container[i] = Integer.parseInt(st.nextToken());
		}

		while(true){
			cnt++;

			// 1. 컨테이너 벨트 회전
			rotation();

			// 2. 로봇 이동
			moveRobot();

			// 3. 로봇 올리기
			raiseRobot();

			// 4. 내구도 확인
			int check = 0;
			for(int i=0; i<containerSize; i++){
				if(container[i] == 0){
					check++;
				}
				if(check >= k){
					System.out.println(cnt);
					return;
				}
			}
		}
	}

	public static void rotation(){
		// 벨트 회전
		int tmp = container[containerSize-1];
		for(int i=containerSize-1; i>0; i--){
			container[i] = container[i-1];
		}
		container[0] = tmp;

		// 로봇 회전
		for(int i=n-1; i>0; i--){
			robot[i] = robot[i-1];
		}
		robot[0] = false;

		if(robot[n-1]){
			robot[n-1] = false;
		}
	}

	public static void moveRobot(){
		for(int i=n-1; i>0; i--){
			if(container[i]>0 && !robot[i] && robot[i-1]){
				robot[i] = robot[i-1];
				robot[i-1] = false;

				container[i]--;
			}
		}

		if(robot[n-1]){
			robot[n-1] = false;
		}
	}

	public static void raiseRobot(){
		if(container[0] > 0){
			robot[0] = true;
			container[0]--;
		}
	}
}
