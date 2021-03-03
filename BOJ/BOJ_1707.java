package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_1707 {
	static LinkedList<Integer>[] arr;
	static boolean[] visited;
	static boolean[] check;
	static int v, e;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// 정점과 간선 입력
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			
			// 정점 별 그래프 초기화
			arr = new LinkedList[v+1];
			visited = new boolean[v+1];
			for(int j=1; j<=v; j++) {
				arr[j] = new LinkedList<>();
			}
			
			for(int j=0; j<e; j++) {
				st = new StringTokenizer(br.readLine());
				
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				arr[start].add(end);
				arr[end].add(start);
			}
			
			String result = "YES";
			// check는 인접한 그래프끼리 서로 다른 색을 칠할 수 있는지
			// 확인할 수 있는 배열
			check = new boolean[v+1];
			for(int j=1; j<=v; j++) {
				if(!visited[j]) {
					// 인접한 그래프 별로 BFS 수행
					boolean tmp = BFS(j);
					
					if(!tmp) {
						result = "NO";
						break;
					}
				}
			}
			
			System.out.println(result);
		}
	}
	
	public static boolean BFS(int idx) {
		Queue<Integer> q = new LinkedList<>();
		check[idx] = true;
		visited[idx] = true;
		q.offer(idx);
		
		while(!q.isEmpty()) {
			int loc = q.poll();
			
			for(int next : arr[loc]) {
				if(!visited[next]) {
					// 인접한 그래프끼리 현재 위치가 true면 다음 노드는 false로 (번갈아 입력)
					if(!check[loc]) {
						check[next] = true;
					}
					
					q.offer(next);
					visited[next] = true;
				} else {
					// 만약 방문한 그래프라면 인접한 그래프끼리
					// 같은 색이 칠해져 있는지 확인
					// 같은 색이 칠해져 있다면 이분 그래프가 될 수 없음
					if(check[loc] == check[next])
						return false;
				}
			}
		}
		
		// BFS를 모두 잘 통과했다면 true
		return true;
	}
}
