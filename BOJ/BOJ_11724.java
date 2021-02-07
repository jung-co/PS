package BOJ;

import java.util.*;
import java.io.*;

class BOJ_11724
{
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static int n;
    static char[][] map;
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        map = new char[n][n];
        visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            map[i] = br.readLine().toCharArray();
        }
        
        int count = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && map[i][j] == '1'){
                    q.offer(BFS(i, j));
                    count++;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            sb.append(q.poll() + "\n");
        }
        
        System.out.println(count + "\n" + sb);
    }
    
    public static int BFS(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        visited[x][y] = true;
        
        int count = 1;
        while(!q.isEmpty()){
            int[] loc = q.poll();
            
            for(int i=0; i<4; i++){
                int nx = loc[0] + dx[i];
                int ny = loc[1] + dy[i];
                
                if(nx>=0 && ny>=0 && nx<n && ny<n){
                    if(!visited[nx][ny] && map[nx][ny] == '1'){
                        count++;
                        visited[nx][ny] = true;
                        q.offer(new int[] {nx, ny});
                    }
                }
            }
        }
        
        return count;
    }
}