package BOJ;

import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ_2667 {
    static int[] dr = {1, -1, 0, 0};
    static int[] du = {0, 0, 1, -1};
    
    static int[][] map;
    static boolean[][] visited;
    
    static int n = 0;
    static int apart = 0;
    static ArrayList<Integer> arr = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 단지의 한 변의 길이
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<n; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] != 0 && !visited[i][j]){
                    apart = DFS(i,j);
                    arr.add(apart);
                }
            }
        }
        
        Collections.sort(arr);
        System.out.println(arr.size());
        for(int i=0; i<arr.size(); i++){
            System.out.println(arr.get(i));
        }
        
        br.close();
    }
    
    public static void BFS(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        visited[x][y] = true;
        
        int cnt = 1;
        
        while(!queue.isEmpty()){
            int[] loc = queue.poll();
            
            for(int i=0; i<4; i++){
                int r = loc[0] + dr[i];
                int u = loc[1] + du[i];
                
                if(isTrue(r, u)){
                    if(!visited[r][u] && map[r][u] == 1){
                        queue.offer(new int[] {r, u});
                        visited[r][u] = true;
                        cnt++;
                    }
                }
            }
        }
        arr.add(cnt);
    }
    
    public static int DFS(int x, int y){
        visited[x][y] = true;
        int num = 1;
        
        for(int i=0; i<4; i++){
            int nx = x + dr[i];
            int ny = y + du[i];
            
            if(isTrue(nx, ny)){
                if(map[nx][ny] == 1 && !visited[nx][ny]){
                    num += DFS(nx, ny);
                }
            }
        }
        
        return num;
    }
    
    public static boolean isTrue(int r, int u){
        return r>=0 && u>=0 && r<n && u<n;
    }
}