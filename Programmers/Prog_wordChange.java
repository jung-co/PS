package Programmers;

import java.util.*;
import java.io.*;

public class Prog_wordChange {
	public static class Change {
		String str;
		int count;
		
		public Change(String str, int count) {
			this.str = str;
			this.count = count;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
	}
	
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        int count = 0;
        for(int i=0; i<words.length; i++) {
        	if(words[i].equals(target)) {
        		count++;
        		break;
        	}
        }
        
        if(count == 0) return 0;
        else answer = BFS(begin, target, words);
        
        return answer;
    }
    
    public int BFS(String begin, String target, String[] words) {
    	boolean[] visited = new boolean[words.length];
    	Queue<Change> q = new LinkedList<>();
    	q.offer(new Change(begin, 0));
    	
    	while(!q.isEmpty()) {
    		Change loc = q.poll();

            if(loc.str.equals(target)) return loc.count;
            
    		for(int i=0; i<words.length; i++) {
    			if(!visited[i]) {
        			int count = 0;
        			for(int j=0; j<words[i].length(); j++) {
        				char locc = loc.str.charAt(j);
        				char worc = words[i].charAt(j);
        				
        				if(locc != worc) count++; 
        			}
        			
        			if(count == 1) {
        				q.offer(new Change(words[i], loc.count + 1));
        				visited[i] = true;
        			}
    			}
    		}
    	}
    	
    	return 0;
    }
}