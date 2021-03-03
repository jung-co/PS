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
			
			// ������ ���� �Է�
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			
			// ���� �� �׷��� �ʱ�ȭ
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
			// check�� ������ �׷������� ���� �ٸ� ���� ĥ�� �� �ִ���
			// Ȯ���� �� �ִ� �迭
			check = new boolean[v+1];
			for(int j=1; j<=v; j++) {
				if(!visited[j]) {
					// ������ �׷��� ���� BFS ����
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
					// ������ �׷������� ���� ��ġ�� true�� ���� ���� false�� (������ �Է�)
					if(!check[loc]) {
						check[next] = true;
					}
					
					q.offer(next);
					visited[next] = true;
				} else {
					// ���� �湮�� �׷������ ������ �׷�������
					// ���� ���� ĥ���� �ִ��� Ȯ��
					// ���� ���� ĥ���� �ִٸ� �̺� �׷����� �� �� ����
					if(check[loc] == check[next])
						return false;
				}
			}
		}
		
		// BFS�� ��� �� ����ߴٸ� true
		return true;
	}
}
