package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_11655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder ans = new StringBuilder();
        String str = br.readLine();
        for(int i=0; i<str.length(); i++) {
        	char ch = str.charAt(i);
        	
        	if(ch>='A' && ch<='Z') {
        		ch = (char)((ch-'A'+13)%26 + 'A');
        	} else if(ch>='a' && ch<='z') {
        		ch = (char)((ch-'a'+13)%26 + 'a');
        	}
        	
        	ans.append(ch);
        }
        
        System.out.println(ans);
    }
}