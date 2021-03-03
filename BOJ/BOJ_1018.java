package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1018 {
	static char[] BW = {'B', 'W'};
    static char[][] chess;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
       
        chess = new char[N][M];
        for(int i=0; i<N; i++){
            chess[i] = br.readLine().toCharArray();
        }
        
        int min = Integer.MAX_VALUE;
        for(int i=0; i<N-7; i++){
            for(int j=0; j<M-7; j++){
            	int b_cnt = chessMake(i, j, 0); // B
            	int w_cnt = chessMake(i, j, 1); // W
            	
            	min = Math.min(min, Math.min(b_cnt, w_cnt));
            }
        }
        
        System.out.println(min);
    }
    
    public static int chessMake(int x, int y, int idx){
    	int count = 0;
    	
    	for(int i=x; i<x+8; i++) {
    		for(int j=y; j<y+8; j++) {
    			if(chess[i][j] == BW[idx]) {
    				if(j%2 != y%2) count++;
    			} else {
    				if(j%2 == y%2) count++;
    			}
    		}
    		
    		if(idx == 0) idx = 1;
    		else idx = 0;
    	}
    	
    	return count;
    }
}