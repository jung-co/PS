package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_1003 {
    static int[][] memo;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        
        for(int i=0; i<test; i++){
            int node = Integer.parseInt(br.readLine());
            
            memo = new int[node+1][2];
            memo[0][0] = 1;
            memo[1][1] = 1;
            
            DP(node, 0);
            DP(node, 1);
            
            System.out.println(memo[node][0]+ " " + memo[node][1]);
        }
    }
    
    public static int DP(int node, int idx){
        if(node < 2){
            return memo[node][idx];
        }
        
        if(memo[node][idx] == 0){
            memo[node][idx] = DP(node-1, idx) + DP(node-2, idx);
        } return memo[node][idx];
    }
}