package BOJ;
import java.io.*;
import java.util.*;

public class BOJ_9205 {
    static int[] start = new int[2];
    static int[] end = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int a=0; a<t; a++){
            int n = Integer.parseInt(br.readLine());
            boolean result = false;

            ArrayList<int[]> map = new ArrayList<>();
            for(int i=0; i<n+2; i++){
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                if(i==0){
                    start[0] = x;
                    start[1] = y;
                } else if(i==(n+1)){
                    end[0] = x;
                    end[1] = y;
                } else {
                    map.add(new int[] {x, y});
                }

                result = BFS(map, n);
            }

            if(result){
                System.out.println("happy");
            }else {
                System.out.println("sad");
            }
        }
    }

    public static boolean BFS(ArrayList<int[]> map, int n) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.add(new int[] {start[0], start[1]});

        while(!q.isEmpty()){
            int[] now = q.poll();

            if((Math.abs(now[0]-end[0]) + Math.abs(now[1]-end[1])) <= 1000){
                return true;
            }

            for(int i=0; i<n; i++){
                if(!visited[i]){
                    int nx = map.get(i)[0];
                    int ny = map.get(i)[1];

                    if((Math.abs(now[0]-nx) + Math.abs(now[1]-ny)) <= 1000){
                        visited[i] = true;
                        q.add(new int[] {nx, ny});
                    }
                }
            }
        }

        return false;
    }
}
