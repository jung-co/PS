package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_4153 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			int[] tri = new int[3];
			tri[0] = Integer.parseInt(st.nextToken());
			tri[1] = Integer.parseInt(st.nextToken());
			tri[2] = Integer.parseInt(st.nextToken());
			
			if(tri[0] == 0)
				break;
			
			Arrays.sort(tri);
			double[] result = new double[2];
			result[1] = Math.pow(tri[2], 2);
			result[0] = Math.pow(tri[0], 2) + Math.pow(tri[1], 2);
			
			if(result[1] == result[0])
				System.out.println("right");
			else
				System.out.println("wrong");
			
		}
	}
}
