package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15686 {
	static int n, m;
	static int answer = Integer.MAX_VALUE;

	static int[][] map;
	static ArrayList<int[]> chicken = new ArrayList<>();
	static ArrayList<int[]> home = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++){
				map[i][j] = Integer.parseInt(st.nextToken());

				if(map[i][j] == 2){
					chicken.add(new int[] {i, j});
				} else if(map[i][j] == 1){
					home.add(new int[] {i, j});
				}
			}
		}

		if(chicken.size() == m){
			checkDist(chicken);
		} else {
			for(int i=0; i<chicken.size(); i++){
				ArrayList<int[]> arr = new ArrayList<>();
				arr.add(chicken.get(i));

				choice(i, arr);
			}
		}

		System.out.println(answer);
	}

	public static void choice (int idx, ArrayList<int[]> arr){
		if(arr.size() == m){
			checkDist(arr);
			return;
		}

		for(int i=idx+1; i<chicken.size(); i++){
			arr.add(chicken.get(i));
			choice(i, arr);
			arr.remove(arr.size()-1);
		}
	}

	public static void checkDist(ArrayList<int[]> arr){
		int totalDist = 0;

		for(int i=0; i<home.size(); i++){
			int min = Integer.MAX_VALUE;

			for(int j=0; j<arr.size(); j++){
				int dist = Math.abs(home.get(i)[0] - arr.get(j)[0])
						+ Math.abs(home.get(i)[1] - arr.get(j)[1]);
				if(dist < min){
					min = dist;
				}
			}

			totalDist += min;
		}

		if(totalDist < answer){
			answer = totalDist;
		}
	}
}
