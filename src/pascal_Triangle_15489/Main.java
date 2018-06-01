package pascal_Triangle_15489;

import java.util.Scanner;

public class Main {

	public static int pascal(int n, int k) {
		if (k == 0) {
			return 1;
		}
		if (n == k) {
			return 1;
		}
		return pascal(n - 1, k - 1) + pascal(n - 1, k);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int sum = 0;
		int R = scanner.nextInt() - 1;
		int C = scanner.nextInt() - 1;
		int W = scanner.nextInt();
		int i = 0;
		// ���� R ���� R+W����
		for (int x = R; x < R + W; x++) {
			// ���� C���� C+i����
			for (int y = C; y <= C + i; y++) {
				sum += pascal(x,y);
			}
			i++;
		}
		System.out.println(sum);
	}

}
