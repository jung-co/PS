package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1389 {
    static int N, M;
    static int[][] count;
    static LinkedList<Integer>[] friends;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        friends = new LinkedList[N+1];
        count = new int[N+1][N+1];
        for(int i=0; i<=N; i++){
            friends[i] = new LinkedList<>();
            Arrays.fill(count[i], -1);
        }
        
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            friends[a].add(b);
            friends[b].add(a);
        }
        
        for(int i=1; i<=N; i++){
            BFS(i);
        }
        
        for(int i=1; i<=N; i++){
        	int sum = 0;
            for(int j=1; j<=N; j++){
                sum += count[i][j];
            } count[i][0] = sum;
        }
        
        int min = count[1][0];
        int idx = 1;
        for(int i=2; i<=N; i++){
            if(min > count[i][0]){
                min = count[i][0];
                idx = i;
            }
        }
        
        System.out.println(idx);
    }
    
    public static void BFS(int x){
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        count[x][x] += 1;
        
        while(!q.isEmpty()){
            int loc = q.poll();
            
            Iterator<Integer> iter = friends[loc].iterator();
            while(iter.hasNext()){
                int tmp = iter.next();
                if(count[x][tmp] == -1){
                    q.offer(tmp);
                    count[x][tmp] = count[x][loc] + 1;
                    count[tmp][x] = count[x][loc] + 1;
                }
            }
        }
    }
}