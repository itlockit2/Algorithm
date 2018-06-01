package postfix_notation_1918;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		try {
			Stack<Character> stk = new Stack<>();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			String str = br.readLine();
			// 문자열을 문자배열로
			char chr[] = new char[str.length()];
			chr = str.toCharArray();
			for (char ch : chr) {
				// 피연산자를 만나면 바로 출력을 한다.
				if ('A' <= (int) ch && (int) ch <= 'Z') {
					bw.write(ch);
					bw.flush();
					// 연산자 * 와 / 일때
				} else if (ch == '*' || ch == '/') {
					// 만약 stack이 비어있다면 넣어준다
					if (stk.isEmpty()) {
						stk.add(ch);
						// 같은 우선순위 일경우 stack의 peek를 출력하고 ch는 stack에 저장한다.
					} else if (stk.peek() == '*' || stk.peek() == '/') {
						bw.write(stk.pop());
						bw.flush();
						stk.add(ch);
					} else {
						// 낮은 우선순위 일경우 단순 하게 ch를 stack에 넣어준다.
						stk.add(ch);
					}
					// 연산자가 + 와 - 일때
				} else if (ch == '+' || ch == '-') {
					// 만약 stack이 비어잇거나 왼쪽괄호를 만나면 스택에 넣어준다.
					if (stk.isEmpty() || stk.peek() == '(') {
						stk.add(ch);
						// 그게 아니라면 비어있거나 왼쪽괄호를 만날때 까지 스택에 있는것을 출력한다.
					} else {
						while (!stk.isEmpty() && stk.peek() != '(') {
							bw.write(stk.pop());
							bw.flush();
						}
						stk.add(ch);
					}
					// 왼족 괄호를 만난경우 스택에 넣어준다.
				} else if (ch == '(') {
					stk.add(ch);
					// 오른쪽 괄호를 만난 경우 왼쪽 괄호를 만날때 까지 스택에 있는 내용을 출력한다.
				} else if (ch == ')') {
					while (stk.peek() != '(') {
						bw.write(stk.pop());
						bw.flush();
					}
					stk.pop();
				}
			}
			while (!stk.isEmpty()) {
				bw.write(stk.pop());
				bw.flush();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
