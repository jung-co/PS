package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_1012 {
    static int[] dr = {-1, 1, 0, 0};
    static int[] du = {0, 0, -1, 1};
    
    static int M;
    static int N;
    static int val;
    
    static int[][] map;
    static boolean[][] visited;
    
    static int count = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        
        for(int i=0; i<test; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            count = 0;
            
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            val = Integer.parseInt(st.nextToken());
            
            map = new int[N][M];
            visited = new boolean[N][M];
            
            for(int j=0; j<val; j++){
                String[] str = br.readLine().split(" ");
                
                int sx = Integer.parseInt(str[0]);
                int sy = Integer.parseInt(str[1]);
                
                map[sy][sx] = 1;
            }
            
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    if(map[j][k] == 1 && !visited[j][k]){
                        BFS(k, j);
                        count++;
                    }
                }
            } System.out.println(count);
        }
    }
    
    public static void BFS(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        
        while(!q.isEmpty()){
            int[] loc = q.poll();
            visited[loc[1]][loc[0]] = true;
            
            for(int i=0; i<4; i++){
                int dx = loc[0] + dr[i];
                int dy = loc[1] + du[i];
                
                if(dx>=0 && dy>=0 && dx<x && dy<y){
                    int tmp = map[dy][dx];
                    if(!visited[dy][dx] && map[dy][dx] == 1){
                        q.offer(new int[] {dx, dy});
                        visited[dy][dx] = true;
                    }
                }
            }
        }
    }
}