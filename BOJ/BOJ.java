package BOJ;

import java.util.*;
import java.io.*;

public class BOJ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int a = Integer.parseInt(st.nextToken() + st.nextToken());
        int b = Integer.parseInt(st.nextToken() + st.nextToken());
        
        System.out.println(a+b);
    }
}
