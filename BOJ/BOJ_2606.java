package BOJ;

import java.util.*;
import java.io.*;

class BOJ_2606 {
    static int node_num;
    static int edge_num;
    
    static LinkedList<Integer>[] virus;
    static boolean[] visited;
    
    static int count = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        node_num = Integer.parseInt(br.readLine());
        edge_num = Integer.parseInt(br.readLine());
        
        virus = new LinkedList[node_num + 1];
        visited = new boolean[node_num + 1];
        
        for(int i=1; i<node_num+1; i++){
            virus[i] = new LinkedList<>();
        }
        
        for(int i=1; i<edge_num+1; i++){
        	String[] str = br.readLine().split(" ");
        	
            int pre = Integer.parseInt(str[0]);
            int next = Integer.parseInt(str[1]);
            
            virus[pre].add(next);
        }

        DFS(1);
        System.out.println(count);
    }
    
    public static void BFS(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        
        while(!q.isEmpty()){
            int node = q.poll();

            /* 시작 노드와 연결된 노드들을 불러와 담아준다. */
            Iterator<Integer> iter = virus[node].iterator();
            while(iter.hasNext()){
                /* 연결된 노드가 있으면 다음 노드를 i값에 넣어준다. */
                int i = iter.next();

                /* 다음 노드를 방문하지 않았으면 그 다음 노드를 큐에 넣고 count */
                if(!visited[i]){
                    q.offer(i);
                    visited[i] = true;
                    count++;
                }
            }
        }
    }
    
    public static void DFS(int node){
        visited[node] = true;
        Iterator<Integer> iter = virus[node].iterator();
        
        while(iter.hasNext()){
            int i = iter.next();
            if(!visited[i]){
                DFS(i);
                count++;
            }
        }
    }
}