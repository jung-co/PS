package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_1991 {
	static StringBuilder sb = new StringBuilder();
	static Node[] node;
	
	public static class Node {
		Character left;
		Character right;
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		node = new Node[n];
		for(int i=0; i<n; i++) {
			node[i] = new Node();
		}
		
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = st.nextToken().charAt(0) - 'A';
			
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			if(left != '.') node[idx].left = left;
			if(right != '.') node[idx].right = right;
		}
		
		preorder(0); sb.append("\n");
		inorder(0); sb.append("\n");
		postorder(0);
		
		System.out.println(sb);
	}
	
	public static void preorder(int idx) {
		sb.append((char)(idx + 'A'));
		
		if(node[idx].left != null)
			preorder(node[idx].left - 'A');
		
		if(node[idx].right != null)
			preorder(node[idx].right - 'A');
	}
	
	public static void inorder(int idx) {
		
		if(node[idx].left != null) {
			inorder(node[idx].left - 'A');
		}
		
		sb.append((char)(idx + 'A'));
		
		if(node[idx].right != null)
			inorder(node[idx].right - 'A');
	}
	
	public static void postorder(int idx) {
		
		if(node[idx].left != null)
			postorder(node[idx].left - 'A');
		
		if(node[idx].right != null)
			postorder(node[idx].right - 'A');

		sb.append((char)(idx + 'A'));
		
	}
}
