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

	// ���� ����
	public void add(int number) {
		// ���� �Է� number�� Ʈ���� number���� ũ�ٸ� ������ ���� �־��ش�.
		if (this.number < number) {
			// �̶� ������ ����� ���� ���������ش�.
			rightNodeCount++;
			// �̶� ��尡 ������� �ʴٸ� add�Լ��� ȣ���Ͽ� �־��ش�.
			if (rightNode != null) {
				rightNode.add(number);
			} else {
				// �̶� ��尡 ����ִٸ� rightNode�� ���� �־��ش�.

				rightNode = new Tree(number);
			}
			// ���� �Է� number�� Ʈ���� number���� �۴ٸ� ���� ���� �־��ش�.
		} else {
			leftNodeCount++;
			if (leftNode != null) {
				leftNode.add(number);
			} else {
				// �̶� ��Ʈ�� ����ִٸ� leftNode�� ���� �־��ش�
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

			// �׽�Ʈ ����
			int T = Integer.parseInt(st.nextToken());
			for (int i = 0; i < T; i++) {
				st = new StringTokenizer(br.readLine());
				// �Է� ����
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
