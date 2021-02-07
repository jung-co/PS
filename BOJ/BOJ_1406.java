package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());
        
        ArrayList<Character> list = new ArrayList<>();
        for(int i=0; i<str.length(); i++) {
        	list.add(str.charAt(i));
        }
        
        int idx = list.size();
        for(int i=0; i<n; i++) {
        	StringTokenizer s = new StringTokenizer(br.readLine());
        	
        	String st = s.nextToken();
        	if(st.equals("L") && idx>0) {
        		idx--;
        	} else if(st.equals("D") && idx<list.size()) {
        		idx++;
        	} else if(st.equals("B") && idx>0) {
        		list.remove(--idx);
        	} else if(st.equals("P")) {
        		char tmp = s.nextToken().charAt(0);
        		if(idx == list.size()) {
        			list.add(tmp);
        			idx++;
        		}
        		else list.add(idx++, tmp);
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        for(char c : list) {
        	sb.append(c);
        }
        
        System.out.println(sb);
        /* linkedList랑 stack 사용 */
        /*
        LinkedList<Character> list = new LinkedList<>();
        Stack<Character> tmp = new Stack<>();
        for(int i=0; i<str.length(); i++) {
        	list.add(str.charAt(i));
        }
        
        int size = str.length(); // 문자열의 길이
        for(int i=0; i<n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	String edit = st.nextToken();
        	if(edit.equals("L") && !list.isEmpty()) {
        		tmp.push(list.removeLast());
        	} else if(edit.equals("D") && size != list.size()) {
        		list.add(tmp.pop());
        	} else if(edit.equals("B") && !list.isEmpty()) {
        		list.removeLast();
        		size--;
        	} else if(edit.equals("P")) {
        		list.add(st.nextToken().charAt(0));
        		size++;
        	}
        }
        
        if(!tmp.isEmpty()) {
        	while(!tmp.isEmpty()) {
        		list.add(tmp.pop());
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        for(char c : list) {
        	sb.append(c);
        }
        
        System.out.println(sb);
        */
    }
}