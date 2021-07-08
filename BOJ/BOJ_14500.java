package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14500 {
    static int n, m, max = 0;
    static int[] dn = {0, 0, -1, 1};
    static int[] dm = {-1, 1, 0, 0};

    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                DFS(i, j, 0, 0);
                cross(i, j);
            }
        }

        System.out.println(max);
    }

    public static void DFS(int x, int y, int depth, int sum){
        if(depth == 4){
            max = Math.max(max, sum);
            return;
        }

        for(int i=0; i<4; i++){
            int nn = x + dn[i];
            int nm = y + dm[i];

            if(nn<n && nm<m && nn>=0 && nm>=0){
                if(!visited[nn][nm]){
                    visited[nn][nm] = true;
                    DFS(nn, nm, depth+1, sum+map[nn][nm]);
                    visited[nn][nm] = false;
                }
            }
        }
    }

    public static void cross(int x, int y){
        int exc = 4;
        int min = Integer.MAX_VALUE;
        int sum = map[x][y];
        for(int i=0; i<4; i++){
            int nn = x + dn[i];
            int nm = y + dm[i];

            if(exc <= 2){
                return;
            }
            if(nn>=0 && nm>=0 && nn<n && nm<m){
                min = Math.min(min, map[nn][nm]);
                sum = sum + map[nn][nm];
            } else {
                exc--;
            }
        }

        if(exc == 4){
            sum = sum - min;
        }
        max = Math.max(max, sum);
    }
}