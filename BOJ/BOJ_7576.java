package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_7576 {
	
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static int n, m;
    static int day=0, count=0;
    static int[][] map;
    static Queue<int[]> q = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        
        int emp = 0;
        map = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0) emp++;
            }
        }
        
        if(emp == 0) {
        	System.out.println(0);
        	return;
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 1){
                    q.offer(new int[] {i, j});
                }
            }
        }
        
        BFS();
        
        if(emp != count) System.out.println(-1);
        else if(day == 0) System.out.println(0);
        else System.out.println(day-1);
    }
    
    public static void BFS(){
        while(!q.isEmpty()){
            int[] loc = q.poll();
            
            for(int i=0; i<4; i++){
                int nx = loc[0] + dx[i];
                int ny = loc[1] + dy[i];
                
                if(nx>=0 && ny>=0 && nx<n && ny<m){
                    if(map[nx][ny] == 0){
                        q.offer(new int[] {nx, ny});
                        map[nx][ny] = map[loc[0]][loc[1]] + 1;
                        day = Math.max(day, map[nx][ny]);
                        count++;
                    }
                }
            }
        }
    }
	
	/*
    static int[][] map;
    static ArrayList<int[]> list = new ArrayList<>();
    
    static int[] dr = {1, -1, 0, 0};
    static int[] du = {0, 0, -1, 1};
    
    static int day = 0;
    static int x;
    static int y;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        
        map = new int[y][x];
        
        for(int i=0; i<y; i++){
            String[] str = br.readLine().split(" ");
            for(int j=0; j<x; j++){
                map[i][j] = Integer.parseInt(str[j]);
            }
        }
        
        BFS();
        
        if(day == 0) {
        	System.out.println(0);
        	return;
        }
        
        for(int i=0; i<y; i++){
            for(int j=0; j<x; j++){
            	
                if(map[i][j] == 0) {
                	day = 0;
                	break;
                }
            }
        }
        
        System.out.println(day-1);
    }
    
    public static void BFS(){
        Queue<int[]> q = new LinkedList<int[]>();
        
        for(int i=0; i<y; i++){
            for(int j=0; j<x; j++){
                if(map[i][j]>0){
                    q.offer(new int[] {i, j});
                }
            }
        }
        
        while(!q.isEmpty()){
            int[] loc = q.poll();
            for(int i=0; i<4; i++){
                int rr = loc[0] + dr[i];
                int uu = loc[1] + du[i];
                
                if(rr>=0 && uu>=0 && rr<y && uu<x){
                    if(map[rr][uu]==0){
                        q.offer(new int[] {rr, uu});
                        map[rr][uu] = map[loc[0]][loc[1]] + 1;
                        day = map[rr][uu];
                    }
                }
            }
        }
    }
    */
}