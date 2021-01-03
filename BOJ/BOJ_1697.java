package BOJ;

import java.util.*;
import java.io.*;

class BOJ_1697 {
    static int N, K;
    static int[] dir = {1, -1, 2};
    static int[] seconds = new int[100001];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        if(N == K) System.out.println(0);
        else System.out.println(BFS(N));
    }
    
    public static int BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        seconds[start] = 1;
        
        while(!q.isEmpty()){
            int d = q.poll();
            for(int i=0; i<3; i++){
                int tmp = 0;
                if(i==0 || i==1){
                    tmp = d + dir[i];
                } else {
                    tmp = d * dir[i];
                }
                
                if(tmp == K) return seconds[d];
                
                if(tmp>=0 && seconds[tmp] == 0 && tmp<seconds.length){
                    q.offer(tmp);
                    seconds[tmp] = seconds[d] + 1;
                }
            }
        }
        return 0;
    }
    
}