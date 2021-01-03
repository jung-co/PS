package BOJ;

import java.util.*;
import java.io.*;

class Point {
    int x;
    int y;
    int z;
    
    public Point(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

class BOJ_7569 {
    static int m, n, h;
    static int[] dm = {1, -1, 0, 0, 0, 0};
    static int[] dn = {0, 0, -1, 1, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};
    
    static int[][][] box;
    static Queue<Point> q = new LinkedList<>();
    
    static int day = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        
        box = new int[h][n][m];
        
        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                String[] layer = br.readLine().split(" ");
                for(int k=0; k<m; k++){
                    box[i][j][k] = Integer.parseInt(layer[k]);
                    if(box[i][j][k] > 0) q.offer(new Point(k, j, i));
                }
            }
        }
        
        BFS();
        
        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    if(box[i][j][k] == 0){
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        if(day == 0) {
            System.out.println(day);
            return;
        }
        
        System.out.println(day-1);
    }
    
    public static void BFS() {
                
        while(!q.isEmpty()){
            Point p = q.poll();
            
            for(int i=0; i<6; i++){
                int x = p.x + dm[i];
                int y = p.y + dn[i];
                int z = p.z + dh[i];
                
                if(x>=0 && y>=0 && x<m && y<n && z>=0 && z<h){
                    if(box[z][y][x] == 0){
                        q.offer(new Point(x, y, z));
                        box[z][y][x] = box[p.z][p.y][p.x] + 1;
                        day = box[z][y][x];
                    }
                }
            }
        }
    }
}