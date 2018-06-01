package repeat_string_2675;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for (int i = 0; i < T; i++) {
			int num = scanner.nextInt();
			String str = scanner.next();
			for (int y = 0; y < str.length(); y++) {
				for (int x = 0; x < num; x++) {
					System.out.print(str.charAt(y));
				}
			}
			System.out.println();
		}
	}
}
