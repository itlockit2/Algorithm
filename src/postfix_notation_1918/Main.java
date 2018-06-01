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
			// ���ڿ��� ���ڹ迭��
			char chr[] = new char[str.length()];
			chr = str.toCharArray();
			for (char ch : chr) {
				// �ǿ����ڸ� ������ �ٷ� ����� �Ѵ�.
				if ('A' <= (int) ch && (int) ch <= 'Z') {
					bw.write(ch);
					bw.flush();
					// ������ * �� / �϶�
				} else if (ch == '*' || ch == '/') {
					// ���� stack�� ����ִٸ� �־��ش�
					if (stk.isEmpty()) {
						stk.add(ch);
						// ���� �켱���� �ϰ�� stack�� peek�� ����ϰ� ch�� stack�� �����Ѵ�.
					} else if (stk.peek() == '*' || stk.peek() == '/') {
						bw.write(stk.pop());
						bw.flush();
						stk.add(ch);
					} else {
						// ���� �켱���� �ϰ�� �ܼ� �ϰ� ch�� stack�� �־��ش�.
						stk.add(ch);
					}
					// �����ڰ� + �� - �϶�
				} else if (ch == '+' || ch == '-') {
					// ���� stack�� ����հų� ���ʰ�ȣ�� ������ ���ÿ� �־��ش�.
					if (stk.isEmpty() || stk.peek() == '(') {
						stk.add(ch);
						// �װ� �ƴ϶�� ����ְų� ���ʰ�ȣ�� ������ ���� ���ÿ� �ִ°��� ����Ѵ�.
					} else {
						while (!stk.isEmpty() && stk.peek() != '(') {
							bw.write(stk.pop());
							bw.flush();
						}
						stk.add(ch);
					}
					// ���� ��ȣ�� ������� ���ÿ� �־��ش�.
				} else if (ch == '(') {
					stk.add(ch);
					// ������ ��ȣ�� ���� ��� ���� ��ȣ�� ������ ���� ���ÿ� �ִ� ������ ����Ѵ�.
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
