import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String a = st.nextToken();
		//int a = Integer.parseInt(st.nextToken());
		    
		int cnt = a.charAt(0);
		int tmp = 'a';
		while(tmp <= cnt) {
		    System.out.print((char)tmp++ + " ");
		}
		
	}
}
