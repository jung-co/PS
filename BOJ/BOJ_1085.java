package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class BOJ_1085 {
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
        
		int x_min = Math.min(x, w-x);	// x�� �ּҰŸ�
		int y_min = Math.min(y, h-y);	// y�� �ּҰŸ�
        
		// x�� y�� �ּҰŸ� �� ���� ���� ��
		System.out.println(Math.min(x_min, y_min));
	}
 
}