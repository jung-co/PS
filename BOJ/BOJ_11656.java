package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        PriorityQueue<String> q = new PriorityQueue<>();
        for(int i=0; i<str.length(); i++) {
        	q.add(str.substring(i));
        }
        
        int size = q.size();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<size; i++) {
        	sb.append(q.poll() + "\n");
        }
        
        System.out.println(sb);
    }
}