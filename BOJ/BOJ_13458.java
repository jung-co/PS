package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_13458 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++){
			a[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		long cnt = 0;
		for(int i=0; i<n; i++){
			cnt++;
			if(a[i] > b) {
				a[i] -= b;
				while(true){
					int p = (int)(a[i]/c);
					int r = a[i]%c;

					if(p==0){
						if(r!=0){
							cnt++;
						}
						break;
					}

					a[i] = r;
					cnt += p;
				}
			}
		}

		System.out.println(cnt);
	}
}
