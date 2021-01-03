package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1018 {
    static char[][] chess;
    static char[] BW = {'B', 'W'};
    static int count = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
       
        chess = new char[N][M];
        for(int i=0; i<N; i++){
            chess[i] = br.readLine().toCharArray();
        }
        
        int min = 0;
        if(N == 8 && M == 8) {
        	chessMake(0, 0, chess[0][0]);
        	System.out.println(count);
        	return;
        }
        
        int n = N-8;
        int m = M-8;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                chessMake(i, j, chess[i][j]);
                if(min > count){
                    min = count;
                }
            }
        }
        
        System.out.println(min);
    }
    
    public static void chessMake(int y, int x, char ch){
        count = 0;
        int idx = 0;
        if(ch == BW[1]) idx = 1;
        
        for(int i=y; i<y+8; i++){
            for(int j=x; j<x+8; j++){
                char tmp = chess[i][j];
                
                if(j%2 == idx){
                    if(ch != BW[idx])
                        count++;
                } else {
                    if(ch != BW[j%2])
                        count++;
                }
            }
            
            if(idx == 0) idx = 1;
            else idx = 0;
        }
    }
}