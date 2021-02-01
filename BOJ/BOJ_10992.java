package BOJ;
import java.util.*;

class BOJ_10992 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int n = scan.nextInt();
        for(int i=1; i<=n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=1; j<=n-i; j++){
                sb.append(" ");
            }
            
            for(int j=1; j<=i*2-1; j++){
                if(j==1 || j==i*2-1 || i==n) sb.append("*");
                else sb.append(" ");
            }
            
            System.out.println(sb);
        }
    }
}