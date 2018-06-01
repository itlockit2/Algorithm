package parenthesis_string_9012;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		OUTER:
		for (int i = 0; i < T; i++) {
			Stack<Character> stk = new Stack<>();
			String str = scanner.next();
			for (char chr : str.toCharArray()) {
				if (chr == '(') {
					stk.add(')');
				} else if (stk.isEmpty() || chr != stk.pop()) {
					System.out.println("NO");
					continue OUTER;
				}
			}
			if(stk.isEmpty()) {
			System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
