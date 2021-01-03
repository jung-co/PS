package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_7576 {
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
}