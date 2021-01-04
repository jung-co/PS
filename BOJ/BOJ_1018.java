package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1018 {
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
    static char[][] chess;
    static int count = 0;
    
    static int N, M;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
       
        chess = new char[N][M];
        for(int i=0; i<N; i++){
            chess[i] = br.readLine().toCharArray();
        }
        
        int min = Integer.MAX_VALUE;
        for(int i=0; i<N-8; i++){
            for(int j=0; j<M-8; j++){
            	count = 0;
            	chessMake(i, j, 'B', 1);
            	int countB = count;
            	
            	count = 0;
            	chessMake(i, j, 'W', 1);
            	int countW = count;
            	
            	int tmp = Math.min(countW, countB);
            	min = Math.min(min, tmp);
            }
        }
        
        System.out.println(min);
    }
    
    public static void chessMake(int x, int y, char ch, int cnt){
        if(cnt == 8) return;
        
    	if(chess[x][y] != ch) count++;
    	for(int i=0; i<4; i++) {
    		int nx = x + dx[i];
    		int ny = y + dy[i];
    		
    		char tmp = 'B';
    		if(ch == 'B') tmp = 'W';
    		
    		if(isCheck(nx, ny)) {
    			chessMake(nx, ny, tmp, cnt+1);
    		}
    	}
    }
    
    public static boolean isCheck(int x, int y) {
    	return x>=0 && y>=0 && x<N && y<M;
    }
}