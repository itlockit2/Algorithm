package virus_2606;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;

class Tree {
	static Set<Integer> set = new HashSet<>();
	int node;
	Vector<Tree> child = new Vector<>();
	Vector<Tree> parent = new Vector<>();
	boolean isSearch;

	public Tree(int node) {
		this.node = node;
	}

	public void addChild(Tree tree) {
		tree.parent.add(this);
		this.child.add(tree);
	}

	public static void startSearch(Tree tree) {
		if (tree == null || tree.isSearch == true) {
			return;
		}
		tree.isSearch = true;
		set.add(tree.node);
		for(int i = 0; i <tree.parent.size() ; i++) {
		startSearch(tree.parent.get(i));
		}
		for(int i = 0; i <tree.child.size() ; i++) {
		startSearch(tree.child.get(i));
		}
	}
}

public class Main {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());

			int computer = Integer.parseInt(st.nextToken());
			Tree treeSet[] = new Tree[computer];
			for (int i = 0; i < computer; i++) {
				treeSet[i] = new Tree(i + 1);
			}
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			// 노트 연결
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int node = Integer.parseInt(st.nextToken()) - 1;
				int connectNode = Integer.parseInt(st.nextToken()) - 1;
				treeSet[node].addChild(treeSet[connectNode]);
			}
			Tree.startSearch(treeSet[0]);
			System.out.println(Tree.set.size() - 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}