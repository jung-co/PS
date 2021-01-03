package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_4963 {
    static int[] yy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] xx = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[][] map;
    static boolean[][] visited;
    
    static int W;
    static int H;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true){
        	String[] str = br.readLine().split(" ");
            int count = 0;
            
            W = Integer.parseInt(str[0]);
            H = Integer.parseInt(str[1]);
            
            if(W==0 && H==0) return;
            
            map = new int[H][W];
            visited = new boolean[H][W];
            
            /* 입력받은 배열 삽입 */
            for(int i=0; i<H; i++){
                String[] line = br.readLine().split(" ");
                for(int j=0; j<W; j++){
                    map[i][j] = Integer.parseInt(line[j]);
                }
            }
            
            /* 지도를 돌면서 땅이 있는 곳에서 BFS */
            for(int i=0; i<H; i++){
                for(int j=0; j<W; j++){
                    if(!visited[i][j] && map[i][j] == 1){
                        BFS(i, j);
                        count++;
                    }
                }
            }
            
            System.out.println(count);
        }
    }
    
    public static void BFS(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        
        while(!q.isEmpty()){
            int[] loc = q.poll();
            visited[loc[1]][loc[0]] = true;
            
            /* 상하좌우 대각선까지 포함하므로 8방향 */
            for(int i=0; i<8; i++){
                int dx = loc[0] + xx[i];
                int dy = loc[1] + yy[i];
                
                if(isMove(dx, dy)){
                    if(!visited[dy][dx] && map[dy][dx] == 1){
                        q.offer(new int[] {dx, dy});
                        visited[dy][dx] = true;
                    }
                }
            }
        }
    }
    
    public static boolean isMove(int x, int y){
        return x>=0 && y>=0 && x<W && y<H;
    }
}