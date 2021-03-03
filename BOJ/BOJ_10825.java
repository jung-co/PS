package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_10825 {
	public static class Student {
		String name;
		int[] score = new int[3];
		
		public Student(String name, int k, int e, int m) {
			this.name = name;
			score[0] = k;
			score[1] = e;
			score[2] = m;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Student> list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String name = st.nextToken();
			int k = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			list.add(new Student(name, k, e, m));
		}
		
		Collections.sort(list, new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				if(s1.score[0] != s2.score[0]) return s2.score[0] - s1.score[0];
				else if(s1.score[1] != s2.score[1]) return s1.score[1] - s2.score[1];
				else if(s1.score[2] != s2.score[2]) return s2.score[2] - s1.score[2];
				else {
					return s1.name.compareTo(s2.name);
				}
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			sb.append(list.get(i).name + "\n");
		}
		
		System.out.println(sb);
	}
}
