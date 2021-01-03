package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_14889 {
    static int[][] map;
    static ArrayList<Integer> team = new ArrayList<>();
    
    static int N;
    static int check;
    static int result = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        
        for(int i=1; i<N+1; i++){
            String[] str = br.readLine().split(" ");
            for(int j=1; j<N+1; j++){
                map[i][j] = Integer.parseInt(str[j-1]);
            }
        }
        
        for(int i=1; i<N/2+1; i++){
        	check = 0;
            DFS(i);
            
            if(result == 0) break;
        }
        System.out.println(result);
    }
    
    public static void DFS(int node){
        team.add(node);
        
        if(team.size() == N/2){
            teamDiff();
            return;
        }
        
        for(int i=node+1; i<N+1; i++){
            if(!team.contains(i)) {
                DFS(i);
                ArrayList<Integer> arr = team;
                team.remove(team.size()-1);
            }
        }
    }
    
    public static void teamDiff(){
        ArrayList<Integer> link = new ArrayList<>();
        int[] sum = new int[2];
        
        for(int i=1; i<N+1; i++){
            if(!team.contains(i))
                link.add(i);
        }
        
        for(int i=0; i<team.size()-1; i++){
            for(int j=i+1; j<team.size(); j++){
                int[] x = {team.get(i), link.get(i)};
                int[] y = {team.get(j), link.get(j)};
                
                sum[0] += map[x[0]][y[0]] + map[y[0]][x[0]];
                sum[1] += map[x[1]][y[1]] + map[y[1]][x[1]];
            }
        }
        
        int tmp = Math.abs(sum[0] - sum[1]);
        result = Math.min(result, tmp);
    	/*
        int[] sum = new int[2];
        int i=0, j=0;
        for(int k=1; k<N+1; k++){
            j = k;
            if(team.contains(k))
                sum[0] += map[i][j] + map[j][i];
            else
                sum[1] += map[i][j] + map[j][i];
            i = j;
        }
        
        int tmp = Math.abs(sum[0]-sum[1]);
        if(result > tmp)
            result = tmp;
        */
    }
}