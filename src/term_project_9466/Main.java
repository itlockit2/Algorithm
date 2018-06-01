package term_project_9466;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		try {
			long sttime = System.currentTimeMillis();
			BufferedReader br = new BufferedReader(
					new FileReader(new File(Main.class.getResource("461_project_input.txt").getFile())));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			;
			for (int i = 0; i < T; i++) {
				Stack<Integer> stk = new Stack<>();
				st = new StringTokenizer(br.readLine());
				int number = Integer.parseInt(st.nextToken());
				;
				// 해당 학생이 누구를 지목했는지 저장하는 배열
				int student[] = new int[number];
				// 학생이 몇번 지목당했는지 저장하는 배열
				int count[] = new int[number];
				// student 배열에 지목한 학생의 번호를 저장
				st = new StringTokenizer(br.readLine());
				for (int x = 0; x < number; x++) {
					student[x] = Integer.parseInt(st.nextToken()) - 1;
				}
				// 자신이 몇번 지목당했는지 저장하는 배열
				for (int x = 0; x < number; x++) {
					count[student[x]]++;
				}
				// 지목을 한번도 당하지 않은 학생의 수를 stack에 넣어준다.
				for (int x = 0; x < number; x++) {
					if (count[x] == 0)
						stk.add(x);
				}
				// 스택이 빌때까지 반복
				while (!stk.isEmpty()) {
					int temp = stk.pop();
					count[student[temp]]--;
					if (count[student[temp]] == 0)
						stk.add(student[temp]);
				}
				int countNumber = 0;
				for (int x = 0; x < number; x++) {
					if (count[x] == 0)
						countNumber++;
				}
				System.out.println(countNumber);
			}
			long et = System.currentTimeMillis();
			System.out.println((et - sttime) + "ms");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}