package Programmers;

import java.util.*;
import java.io.*;

public class Prog_network {
	static boolean[] visited;
    
	public static void main(String[] args) throws IOException {
		int[][] arr = {{1, 1, 0},
				{1, 1, 0},
				{0, 0, 1}};
		
		System.out.println(solution(3, arr));
	}
	
	public static int solution(int n, int[][] computers) {
        visited = new boolean[n];
        
        int count = 0;
		for(int i=0; i<n; i++) {
			if(!visited[i]) {
				BFS(i, n, computers);
				count++;
			}
        }
		
		return count;
    }
	
	public static void BFS(int node, int n, int[][] computers) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(node);
		
		while(!q.isEmpty()) {
			int loc = q.poll();
			visited[loc] = true;
			
			for(int i=loc+1; i<n; i++) {
				if(computers[loc][i] == 1 && !visited[i]) {
					visited[i] = true;
					
					q.offer(i);
				}
			}
		}
	}
}