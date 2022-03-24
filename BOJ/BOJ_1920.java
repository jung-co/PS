package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int size = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[size];
        for(int i=0; i<size; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int n = Integer.parseInt(br.readLine());
        int num = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            num = Integer.parseInt(st.nextToken());

            int result = 0;
            int left = 0;
            int right = size-1;
            int mid = size/2;
            while(right>=left){
                mid = (left + right) / 2;
//1 2 3 4 5
//1 3 7 9 5
                if(arr[mid]>num) {
                    right = mid-1;
                } else if(arr[mid]<num){
                    left = mid+1;
                } else {
                    result = 1;
                    break;
                }
            }

            System.out.println(result);
        }
    }

}
