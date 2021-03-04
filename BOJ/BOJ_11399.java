package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_11399 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		int[] arr = new int[t];
		StringTokenizer st = new StringTokenizer(br.readLine());
		//PriorityQueue<Integer> q = new PriorityQueue<>();
		for(int i=0; i<t; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int ans = 0;
		int sum = 0;
		for(int i=0; i<t; i++) {
			sum += arr[i];
			ans += sum;
		}
		
		System.out.println(ans);
	}
}
