package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2485 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(br.readLine());
		int[] distance = new int[n];
		for (int i=0; i<n; i++){
			distance[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(distance);

		int l = 0;
		for(int i=0; i<n-1; i++){
			int dis = distance[i+1] - distance[i];
			l = GCD(dis, l);
		}

		System.out.println((distance[n-1] - distance[0])/l+1 - n);
	}

	public static int GCD(int a, int b){
		if(b == 0) return a;
		else return GCD(b, a%b);
	}
}
