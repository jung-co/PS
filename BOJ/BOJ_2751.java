package BOJ;

import java.util.*;
import java.io.*;

class BOJ_2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0; i<n; i++) {
        	int num = Integer.parseInt(br.readLine());
        	q.offer(num);
        }
        
        for(int i=0; i<n; i++) {
        	sb.append(q.poll() + "\n");
        }
        
        System.out.print(sb);
        
        /*
        Collections.sort(num);
        
        for(int val : num) {
        	sb.append(val).append('\n');
        } System.out.println(sb);
        */
    }
}