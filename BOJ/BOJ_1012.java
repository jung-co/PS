package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_1012 {
    static int n, m, cnt = 0;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            cnt = 0;
            st = new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            map = new int[n][m];
            visited = new boolean[n][m];

            int k = Integer.parseInt(st.nextToken());
            for(int j=0; j<k; j++){
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[y][x] = 1;
            }

            for(int j=0; j<n; j++){
                for(int l=0; l<m; l++){
                    if(!visited[j][l] && map[j][l] == 1){
                        cnt++;
                        BFS(j, l);
                    }
                }
            }

            System.out.println(cnt);
        }
    }

    public static void BFS(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        visited[y][x] = true;
        q.offer(new int[] { y, x });

        while(!q.isEmpty()){
            int[] now = q.poll();

            for(int i=0; i<4; i++){
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];

                if(nx>=0 && ny>=0 && nx<m && ny<n){
                    if(!visited[ny][nx] && map[ny][nx]==1){
                        q.offer(new int[] {ny, nx});
                        visited[ny][nx] = true;
                    }
                }
            }
        }
    }
}