package BOJ;

import java.util.*;
import java.io.*;

class BOJ_1697 {
	static int n, k;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        if(n >= k) System.out.println(n - k);
        else System.out.println(BFS(n));
    }
    
    public static int BFS(int idx) {
    	Queue<Integer> q = new LinkedList<>();
    	int[] arr = new int[100001];
    	
    	q.offer(idx);
    	arr[idx] = 1;
    	
    	while(!q.isEmpty()) {
    		int loc = q.poll();
    		
    		for(int i=0; i<3; i++) {
    			int next;
    			
    			if(i == 0) next = loc - 1;
    			else if(i == 1) next = loc + 1;
    			else next = loc * 2;
    			
    			if(next == k) return arr[loc];
    			
    			if(next>=0 && next<arr.length && arr[next] == 0) {    				
    				q.offer(next);
    				arr[next] = arr[loc] + 1;
					
    			}
    		}
    	}
    	
    	return 0;
    }
}