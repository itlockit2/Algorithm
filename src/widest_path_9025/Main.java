package widest_path_9025;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Vector;

class Node {
	int left;
	int right;
	int value;
	Vector<Node> edge = new Vector<Node>();

	public void connect(int right, int value) {
		edge.add(new Node(left, right, value));
	}

	public Node(int left) {
		this.left = left;
		this.right = left;
		value = 0;
	}

	public Node(int left, int right, int value) {
		this.left = left;
		this.right = right;
		this.value = value;
	}
	
	public int maxValue() {
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < edge.size() ; i++) {
			max = max<edge.get(i).value?edge.get(i).value:max;
		}
		return max;
	}
	public int maxNode() {
		int node = 0;
		for(int i = 0 ; i < edge.size() ; i++) {
			if(edge.get(i).value == maxValue())
				node = edge.get(i).right;
		}
		return node;
	}
}

public class Main {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			for (int i = 0; i < T; i++) {
				st = new StringTokenizer(br.readLine());
				int N = Integer.parseInt(st.nextToken());
				Node node[] = new Node[N];
				// node 초기화
				for(int j = 0 ; j < N ; j++) {
					node[j] = new Node(j);
				}
				int M = Integer.parseInt(st.nextToken());
				int S = Integer.parseInt(st.nextToken())-1;
				int D = Integer.parseInt(st.nextToken())-1;
				// 그래프 생성
				for(int j = 0 ; j < M ; j++) {
					st = new StringTokenizer(br.readLine());
					int left = Integer.parseInt(st.nextToken())-1;
					int right = Integer.parseInt(st.nextToken())-1;
					int value = Integer.parseInt(st.nextToken());
					node[left].connect(right, value);
					node[right].connect(left, value);
				}
				// 최대신장트리 생성
				Vector<Integer> nodeNumber = new Vector<Integer>();
				nodeNumber.add(S);
				while(!nodeNumber.contains(D)) {
					// maxValue들을 모은다.
					ArrayList<Integer> maxValue = new ArrayList<Integer>();
					for(int j = 0; j < nodeNumber.size() ; j++){
						maxValue.add(node[nodeNumber.get(j)].maxValue());
					}
					Collections.sort(maxValue);
					
				}
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
