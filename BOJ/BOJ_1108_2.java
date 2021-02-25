package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_1108_2 {
	static boolean[] broken = new boolean[10]; // 0~10

	static int possible(int c) {
		if (c == 0) { //0�϶� ����ó��
			if (broken[0]) {
				return 0;
			} else {
				return 1;
			}
		}
		int len = 0;
		while (c > 0) {
			if (broken[c % 10]) {
				return 0;
			}
			len += 1;
			c /= 10;
		}
		return len;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // �̵� ���ϴ� ä��
		int m = sc.nextInt(); // ���ھ� ä�� ����
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			broken[x] = true; // Ʈ��� ����!
		}

		int ans = Math.abs(n - 100);
		/*
		 * �ʱ� ä���� 100�̴�. ��� �������� ���ڹ�ư�� ���峵�� ��� +-��ư���θ��̵� �����ϵ��� �ʱⰪ�� �������ش�.
		 */

		// 0���� 1000000���� ��� ä���� ���鼭 N���� ���� ���� ��ư�� ���� �̵��� �� �ִ� ä���� ã�´�.
		for (int i = 0; i < 1000000; i++) {
			int c = i;
			int len = possible(c);
			// len ����: c�� ���ڹ�ư���� �̿��ؼ� �̵��� ��������, �����ϴٸ� �� ���� ��ư�� �������� ���ϴ� ����
			if (len > 0) {
				int press = Math.abs(c - n);
				// press: ���ڹ�ư���� n�� �ִ��� �����ϰ� �̵����� +�Ǵ� -�� �� �� ������ �ϴ��� ���ϴ� ����
				if (ans > len + press) {
					ans = len + press;
				}

			}

		}
		System.out.println(ans);
	}
}