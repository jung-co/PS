package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_3053 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double r = Double.parseDouble(br.readLine());
		
		System.out.println(Math.PI * r * r); // ¿øÀÇ ³ÐÀÌ
		System.out.println(2 * r * r);
	}
}
