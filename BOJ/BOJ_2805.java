package BOJ;

import java.util.*;
import java.io.*;

class BOJ_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        } Arrays.sort(arr);
        
        int left = 1;
        int right = arr[n-1];
        int mid;
        
        while(left<=right) {
        	mid = (right+left)/2;
        	
        	long sum = 0;
        	for(int i=0; i<n; i++) {
        		if(arr[i] - mid > 0)
        			sum += arr[i] - mid;
        	}
        	
        	if(sum >= m) {
        		left = mid + 1;
        	} else if(sum < m) {
        		right = mid - 1;
        	}
        }
        
        System.out.println(right);
    }
}