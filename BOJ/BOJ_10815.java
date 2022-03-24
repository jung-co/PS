package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_10815 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			sb.append(search(arr, n, num));

			if (i != m - 1) sb.append(" ");
		}

		System.out.println(sb.toString());
		br.close();
	}

	public static int search(int[] arr, int n, int num) {
		int mid;
		int left = 0, right = n - 1;
		while (left <= right) {
			mid = (left + right) / 2;

			if (arr[mid] == num) {
				return 1;
			} else if (arr[mid] < num) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return 0;
	}
};
