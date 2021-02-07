package BOJ;

import java.util.*;
import java.io.*;

class BOJ_1260 {
    static int n, m, v;
    static LinkedList<Integer>[] list;
    static boolean[] visited;
    
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        
        list = new LinkedList[n+1];
        visited = new boolean[n+1];
        for(int i=0; i<=n; i++){
            list[i] = new LinkedList<Integer>();
        }
        
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            list[start].add(end);
            list[end].add(start);
        }
        
        for(int i=1; i<=n; i++) {
        	Collections.sort(list[i]);
        }
        
        DFS(v); sb.append("\n");
        visited = new boolean[n+1];
        BFS(v);
        
        System.out.println(sb);
    }
    
    public static void DFS(int node){
    	sb.append(node + " ");
        visited[node] = true;
        
        for(int next : list[node]){
        	if(!visited[next]) DFS(next);
        }
    }
    
    public static void BFS(int node){
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visited[node] = true;
        
        while(!q.isEmpty()){
            int loc = q.poll();
            sb.append(loc + " ");
        
            for(int next : list[loc]){
                if(!visited[next]){
                    q.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
}