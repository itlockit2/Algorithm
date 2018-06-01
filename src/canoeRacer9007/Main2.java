package canoeRacer9007;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main2 {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader( System.in ));
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st = new StringTokenizer( br.readLine() );
			// �׽�Ʈ ���̽��� ����
			int T = Integer.parseInt( st.nextToken());
			for (int i = 0; i < T; i++) {
				// ����Ʈ �ʱ�ȭ
				ArrayList<Integer> list_1 = new ArrayList<>();
				ArrayList<Integer> list_2 = new ArrayList<>();
				int result = 0;
				
				st = new StringTokenizer( br.readLine() );
				// ī���� ��
				int k = Integer.parseInt( st.nextToken() );
				// �� Ŭ������ �л���
				int n = Integer.parseInt( st.nextToken() );
				int numArray[][] = new int[n][4];
				for (int x = 0; x < 4; x++) {
					st = new StringTokenizer( br.readLine() );
					for (int y = 0; y < n; y++) {
						numArray[y][x] = Integer.parseInt( st.nextToken());
					}
				}
				// 2���� ��� ArraList�� ����
				for (int x = 0; x < n; x++) {
					for (int y = 0; y < n; y++) {
						// �ߺ��� Ȯ���Ͽ� �迭�� ����
							list_1.add(numArray[x][0] + numArray[y][1]);
					}
				}
				// 2���� ��� ArraList�� ����
				for (int x = 0; x < n; x++) {
					for (int y = 0; y < n; y++) {
						// �ߺ��� Ȯ���Ͽ� �迭�� ����
							list_2.add(numArray[x][2] + numArray[y][3]);
					}
				}
				// �迭�� ����
				//Arrays.sort(list_1);
				//Arrays.sort(list_2);
				// algorithm
				for (int x = 0; x < list_1.size(); x++) {
					int findNumber = k - list_1.get(x);
					int findIndex = Collections.binarySearch(list_2, findNumber);
					// ���� ���� 2��° ����Ʈ�� �����Ѵٸ� ������� ����ϰ� �ݺ����� �����Ѵ�.
					if (findIndex >= 0) {
						result = k;
						break;
						// �������� �ʴ´ٸ�
					} else {
						// �� �ε����� ��ġ�� ����Ѵ�.
						findIndex = (-1 * findIndex) - 1;
						// �ݺ� �ϱ� ���� ������ �����Ѵ�.
						int iterator;
						// �� ���� ����Ʈ�� �ִ� ������ ���� �۰ų� ���� ū��� �� �ε����� Ž���Ѵ�.
						if (findIndex == 0) {
							iterator = findIndex;
						} else if (findIndex == list_2.size()) {
							findIndex--;
							iterator = findIndex;
						} else {
							iterator = findIndex - 1;
						}
						for (int z = findIndex; z >= iterator; z--) {
							int temp = list_1.get(x) + list_2.get(z);
							// �μ��� ���� �� �������� ������̴�.
							if (Math.abs(k - temp) < Math.abs(k - result)) {
								result = temp;
								// ���� �μ��� ���� ���ٸ� �������� ������̴�.
							} else if (Math.abs(k - temp) == Math.abs(k - result)) {
								result = temp < result ? temp : result;
							}
						}
					}
				}
				out.write(result+"\n");
				out.flush();
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
