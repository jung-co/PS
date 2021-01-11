import java.io.*;
import java.util.*;

public class CodeUp_1086 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		       
        long w = Long.parseLong(st.nextToken());
        long h = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        double total = w * h * b;
        
        double result = ((total/8)/Math.pow(2, 10)/Math.pow(2, 10));
        System.out.format("%.2f MB",result);
	}

}