package binarySearch_8944;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Tree {
	int number;
	int level;
	long value;
	int leftNodeCount;
	int rightNodeCount;
	Tree leftNode;
	Tree rightNode;

	public Tree(int number) {
		this.number = number;
	}

	// 숫자 삽입
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
		if (tree.leftNodeCount == 0 && tree.rightNodeCount == 0) {
			tree.value = 1;
			return;
		}
		if (tree.leftNode != null) {
			search(tree.leftNode);
			leftNodeValue = tree.leftNode.value;
		} else {
			leftNodeValue = 1;
		}
		if (tree.rightNode != null) {
			search(tree.rightNode);
			rightNodeValue = tree.rightNode.value;
		} else {
			rightNodeValue = 1;
		}
		tree.value = leftNodeValue * rightNodeValue
				* combination(tree.leftNodeCount + tree.rightNodeCount, tree.leftNodeCount);
		// long result = tree.leftNode.value * tree.rightNode.value * combination()
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
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
				System.out.println(tree.value % 9999991);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
