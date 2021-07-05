package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13460 {
    public static class Now {
        int ri, rj;
        int bi, bj;
        int cnt;

        Now(int ri, int rj, int bi, int bj, int cnt){
            this.ri = ri;
            this.rj = rj;
            this.bi = bi;
            this.bj = bj;
            this.cnt = cnt;
        }
    }

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int rsi = 0; // 빨간 공 시작 위치
        int rsj = 0;
        int bsi = 0; // 파란 공 시작 위치
        int bsj = 0;

        char[][] map = new char[n][m];
        for(int i=0; i<n; i++){
            map[i] = br.readLine().toCharArray();

            for(int j=0; j<m; j++){
                if(map[i][j] == 'R'){
                    rsi = i;
                    rsj = j;
                }
                if(map[i][j] == 'B'){
                    bsi = i;
                    bsj = j;
                }
            }
        }

        // bfs
        Queue<Now> q = new LinkedList<>();
        boolean[][][][] visited = new boolean[n][m][n][m];

        visited[rsi][rsj][bsi][bsj] = true;
        q.offer(new Now(rsi, rsj, bsi, bsj, 0));

        while(!q.isEmpty()){
            Now now = q.poll();

            if(now.cnt > 10){
                System.out.println(-1);
                System.exit(0);
            }
            if(map[now.bi][now.bj] == 'O'){
                continue;
            }
            if(map[now.ri][now.rj] == 'O' && map[now.bi][now.bj] != 'O'){
                System.out.println(now.cnt);
                System.exit(0);
            }
            for(int i=0; i<4; i++){
                // 빨간 공 이동
                int rni = now.ri;
                int rnj = now.rj;

                while(true){
                    rni += dx[i];
                    rnj += dy[i];

                    if(map[rni][rnj] == 'O' || map[rni][rnj] == '#') break;
                }

                if(map[rni][rnj] == '#'){
                    rni -= dx[i];
                    rnj -= dy[i];
                }

                // 파란 공 이동
                int bni = now.bi;
                int bnj = now.bj;

                while(true){
                    bni += dx[i];
                    bnj += dy[i];

                    if(map[bni][bnj] == 'O' || map[bni][bnj] == '#') break;
                }

                if(map[bni][bnj] == '#'){
                    bni -= dx[i];
                    bnj -= dy[i];
                }

                // 예외 처리
                if(rni == bni && rnj == bnj && map[rni][bnj] != 'O'){
                    int dist_red = Math.abs(rni - now.ri) + Math.abs(rnj - now.rj);
                    int dist_blue = Math.abs(bni - now.bi) + Math.abs(bnj - now.bj);

                    if(dist_red > dist_blue){
                        rni -= dx[i];
                        rnj -= dy[i];
                    } else {
                        bni -= dx[i];
                        bnj -= dy[i];
                    }
                }

                // 아직 방문하지 않았다면 큐에 넣기
                if(!visited[rni][rnj][bni][bnj]){
                    visited[rni][rnj][bni][bnj] = true;
                    q.offer(new Now(rni, rnj, bni, bnj, now.cnt+1));
                }
            }
        }

        System.out.println(-1);
    }
}
