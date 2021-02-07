package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_10814 {
	public static class Person {
		int age;
		String name;
		
		public Person(int age, String name) {
			this.age = age;
			this.name = name;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		ArrayList<Person> list = new ArrayList<>();
		for(int i=0; i<t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new Person(Integer.parseInt(st.nextToken()) , st.nextToken()));
		}
		
		Collections.sort(list, new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				return p1.age - p2.age;
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<t; i++) {
			sb.append(list.get(i).age + " " + list.get(i).name + "\n");
		}
		
		System.out.println(sb);
	}
}
