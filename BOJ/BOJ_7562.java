package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_7562 {
	public static class Point {
	    int x;
	    int y;
	    
	    public Point(int x, int y){
	        this.x = x;
	        this.y = y;
	    }
	}
	
    static int[] dy = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dx = {-1, 1, -2, 2, -2, 2, -1, 1};
    
    static int[][] map;
    static boolean[][] visited;
    
    static Point startP;
    static Point endP;
    static int l;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        
        for(int i=0; i<test; i++){
            l = Integer.parseInt(br.readLine());
            
            map = new int[l][l];
            visited = new boolean[l][l];
            
            String[] start = br.readLine().split(" ");
            int sx = Integer.parseInt(start[0]);
            int sy = Integer.parseInt(start[1]);
            startP = new Point(sx, sy);
            
            String[] end = br.readLine().split(" ");
            int ex = Integer.parseInt(end[0]);
            int ey = Integer.parseInt(end[1]);
            endP = new Point(ex, ey);
            
            if(startP.x==endP.x && startP.y==endP.y){
                System.out.println(0);
                continue;
            } BFS(startP);
        }
    }
    
    public static void BFS(Point p){
        Queue<Point> q = new LinkedList<>();
        q.offer(p);
        visited[p.y][p.x] = true; 
              
        while(!q.isEmpty()){
            Point loc = q.poll();
            if(loc.y==endP.y && loc.x==endP.x) {
            	System.out.println(map[loc.y][loc.x]);
            	return;
            }
            
            for(int i=0; i<8; i++){
                int mx = loc.x + dx[i];
                int my = loc.y + dy[i];
                
                if(mx>=0 && mx<l && my>=0 && my<l){
                    if(!visited[my][mx]){
                    	map[my][mx] = map[loc.y][loc.x] + 1;
                        q.offer(new Point(mx, my));
                        visited[my][mx] = true;
                    }
                }
            }
        }
    }
}