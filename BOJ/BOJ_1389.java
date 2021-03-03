package BOJ;

import java.util.*;
import java.io.*;

class BOJ_1389 {
    static int N, M;
    static boolean[] visited;
    static LinkedList<Integer>[] friends;

    public static class Point {
    	int node;
    	int dist;
    	
    	public Point(int node, int dist) {
    		this.node = node;
    		this.dist = dist;
    	}
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        friends = new LinkedList[N+1];
        visited = new boolean[N+1];
        for(int i=0; i<=N; i++){
            friends[i] = new LinkedList<>();
        }
        
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if(!friends[a].contains(b) || !friends[b].contains(a)) {
                friends[a].add(b);
                friends[b].add(a);
            }
        }
        
        int min = Integer.MAX_VALUE;
        int idx = 0;
        for(int i=1; i<=N; i++){
        	visited = new boolean[N+1];
            int tmp = BFS(i, 0);
            
            if(min > tmp) {
            	min = tmp;
            	idx = i;
            }
        }

        System.out.println(idx);
    }
    
    public static int BFS(int x, int count){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, count));
        visited[x] = true;
        
        int result = 0;
        while(!q.isEmpty()){
            Point loc = q.poll();
            result += loc.dist;
            
            Iterator<Integer> iter = friends[loc.node].iterator();
            while(iter.hasNext()){
                int tmp = iter.next();
                if(!visited[tmp]){
                    q.offer(new Point(tmp, loc.dist+1));
                    visited[tmp] = true;
                }
            }
        }
        
        return result;
    }
}