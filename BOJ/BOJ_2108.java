package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2108 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] count = new int[8002];
		long sum = 0;

		long avg = n; // 산술평균
		int mid = 0; // 중앙값
		int max = Integer.MIN_VALUE; // 최빈값
		int dif = 0; // 범위

		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> q = new ArrayList<>();
		for(int i=0; i<n; i++){
			int num = Integer.parseInt(br.readLine());

			list.add(num);
			count[num+4000]++;
			sum += num;

			if(q.isEmpty() || !q.contains(num)){
				q.add(num);
			}
		}
		Collections.sort(list);

		avg = Math.round(sum/avg);
		mid = list.get(n/2);
		dif = list.get(n-1) - list.get(0);

		// 최빈값 찾기
		for(int i=0; i<q.size(); i++){
            int idx = q.get(i);
            int val = count[idx+4000];

            if(max < val){
                max = val;
            }
        }

		// 최빈값 확인
        int ans = 0;
        PriorityQueue<Integer> p = new PriorityQueue<>();
		for(int i=0; i<q.size(); i++){
		    int idx = q.get(i);
		    if(count[idx+4000] == max){
		        p.offer(idx);
		        ans = idx;
            }
        }

		if(p.size() > 1){
		    p.poll();
		    ans = p.poll();
        }

		System.out.println(avg);
		System.out.println(mid);
        System.out.println(ans);
        System.out.println(dif);
	}
}
