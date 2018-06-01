package exploration_10449_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

class Node {
	// 친구를 저장하기 위한 vertics
	ArrayList<Integer> vertics;
	// 친구의 수
	int value;

	public void add(int number) {
		vertics.add(number);
		value++;
	}

	public Node() {
		vertics = new ArrayList<Integer>();
		value = 0;
	}

	public void remove(int number) {
		int index = vertics.indexOf(number);
		vertics.remove(index);
		value--;
	}
}

public class Main {

	public static void main(String[] args) {
		try {
			long sttime = System.currentTimeMillis();
			BufferedReader br = new BufferedReader(
					new FileReader(new File(Main.class.getResource("760_project5_input.txt").getFile())));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			for (int i = 0; i < T; i++) {
				st = new StringTokenizer(br.readLine());
				int N = Integer.parseInt(st.nextToken());
				// node 초기화
				Node node[] = new Node[N];
				for (int j = 0; j < N; j++) {
					node[j] = new Node();
				}
				// c
				int K = Integer.parseInt(st.nextToken());
				int F = Integer.parseInt(st.nextToken());
				// 노드 연결
				for (int j = 0; j < F; j++) {
					st = new StringTokenizer(br.readLine());
					int first = Integer.parseInt(st.nextToken()) - 1;
					int second = Integer.parseInt(st.nextToken()) - 1;
					// 노드들을 연결시켜준다.
					node[first].add(second);
					node[second].add(first);
				}

				Deque<Integer> myQ = new ArrayDeque<Integer>();
				// 친구가 작은 노드들을 dequeue에 담아준다.
				for (int j = 0; j < N; j++) {
					if (node[j].value < K)
						myQ.offer(j);
				}
				// 큐가 빌떄까지 반복
				while (!myQ.isEmpty()) {
					int pop = myQ.poll();
					// pop과 관련된 노드들을 전부 지워준다.
					int size = node[pop].vertics.size();
					for (int j = 0; j < size; j++) {
						int friend = node[pop].vertics.get(0);
						// 내 목록에서 친구를 지운다.
						node[pop].remove(friend);
						// 친구에게서 나를 지운다
						node[friend].remove(pop);
						// 만약 이때 친구의 친구수가 k보다 작다면 큐에 넣어준다.
						if (node[friend].value < K)
							myQ.offer(friend);
					}
				}
				int n = 0;
				// k보다 높은 노드들만 찾아낸다.
				for (int j = 0; j < N; j++) {
					if (node[j].value >= K) {
						n++;
					}

				}
				System.out.println(n);
			}
			long et = System.currentTimeMillis();
			System.out.println((et - sttime) + "ms");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
