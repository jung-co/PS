package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2331 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int a = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        
        ArrayList<Integer> d = new ArrayList<>();
        d.add(a);
        
        int idx = 0;
        while(true) {
        	String str = Integer.toString(d.get(d.size()-1));
        	
        	int tmp = 0;
        	for(int i=0; i<str.length(); i++) {
        		tmp += Math.pow(str.charAt(i) - '0', p);
        	}
        	
        	if(!d.contains(tmp)) {
        		d.add(tmp);
        	} else {
        		idx = d.indexOf(tmp);
        		break;
        	}
        }
        
        System.out.println(idx);
    }
}