package binarySearch_8944_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Tree {
	int number;
	long value;
	int leftNodeCount;
	int rightNodeCount;
	Tree leftNode;
	Tree rightNode;

	public Tree(int number) {
		this.number = number;
	}

	// 숫자 삽입 메소드
	public void add(int number) {
		// 만약 입력 number가 트리의 number보다 크다면 오른쪽 노드로 넣어준다.
		if (this.number < number) {
			// 이때 오른쪽 노드의 수를 증가시켜준다.
			rightNodeCount++;
			// 이때 노드가 비어있지 않다면 add함수를 호출하여 넣어준다.
			if (rightNode != null) {
				rightNode.add(number);
			} else {
				// 이때 노드가 비어있다면 rightNode를 만들어서 넣어준다.
				rightNode = new Tree(number);
			}
			// 만약 입력 number가 트리의 number보다 작다면 왼쪽 노드로 넣어준다.
		} else {
			// 이때 왼쪽 노드의 수를 증가시켜준다.
			leftNodeCount++;
			if (leftNode != null) {
				leftNode.add(number);
			} else {
				// 이때 노트가 비어있다면 leftNode를 만들어서 넣어준다
				leftNode = new Tree(number);
			}
		}
	}

	public void search(Tree tree) {
		long leftNodeValue;
		long rightNodeValue;
		// 만약 왼쪽노드의 개수도 오른쪽노드의 개수도 0개인 즉 단말노드의 경우 value 값은 1이다. 나올수 있는 경우의 수가 1이므로
		if (tree.leftNodeCount == 0 && tree.rightNodeCount == 0) {
			tree.value = 1;
			return;
		}
		// 왼쪽 노드가 비어있지 않다면 먼저 탐색한다.
		if (tree.leftNode != null) {
			search(tree.leftNode);
			// 탐색후 결과값을 저장한다.
			leftNodeValue = tree.leftNode.value;
		} else {
			// 만약 왼쪽노드가 비어있다면 왼쪽노드의 값은 1이다.
			leftNodeValue = 1;
		}
		// 오른쪽 노드가 비어있지 않다면 탐색한다.
		if (tree.rightNode != null) {
			search(tree.rightNode);
			rightNodeValue = tree.rightNode.value;
		} else {
			rightNodeValue = 1;
		}
		// 지금까지 나온 경우의수들을 연산시켜준다.
		tree.value = leftNodeValue * rightNodeValue
				* combination(tree.leftNodeCount + tree.rightNodeCount, tree.leftNodeCount);
	}

	public long factorial(long n) {
		long temp = 1;
		if (n == 0)
			return 1;
		for (int i = 1; i <= n; i++) {
			temp = temp * i;
		}
		return temp;
	}

	public long combination(long n, long k) {
		long p;
		long q;
		p = factorial(n);
		q = factorial(k);
		q = q * factorial(n - k);
		return p / q;
	}
}

public class Main {
	public static void main(String[] args) {
		try {
			long sttime = System.currentTimeMillis();
			BufferedReader br = new BufferedReader(
					new FileReader(new File(Main.class.getResource("372_bst_input.txt").getFile())));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st = new StringTokenizer(br.readLine());

			// 테스트 갯수
			int T = Integer.parseInt(st.nextToken());
			for (int i = 0; i < T; i++) {
				st = new StringTokenizer(br.readLine());
				// 입력 개수
				int N = Integer.parseInt(st.nextToken());
				st = new StringTokenizer(br.readLine());

				Tree tree = new Tree(Integer.parseInt(st.nextToken()));
				for (int j = 0; j < N - 1; j++) {
					tree.add(Integer.parseInt(st.nextToken()));
				}
				tree.search(tree);
				bw.write(tree.value + "\n");
				bw.flush();
			}
			long et = System.currentTimeMillis();
            bw.write((et-sttime) + "ms");
            bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
