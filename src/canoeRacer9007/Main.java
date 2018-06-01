package canoeRacer9007;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		
		try {
			BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st = new StringTokenizer(br.readLine());
			// �׽�Ʈ ���̽��� ����
			int T = Integer.parseInt(st.nextToken());
			for (int i = 0; i < T; i++) {
				int result = Integer.MAX_VALUE;

				st = new StringTokenizer(br.readLine());
				// ī���� ��
				int k = Integer.parseInt(st.nextToken());
				// �� Ŭ������ �л���
				int n = Integer.parseInt(st.nextToken());
				int numArray[][] = new int[4][n];
				int binaryArray[][] = new int[2][n * n];
				for (int x = 0; x < 4; x++) {
					st = new StringTokenizer(br.readLine());
					for (int y = 0; y < n; y++) {
						numArray[x][y] = Integer.parseInt(st.nextToken());
					}
				}
				// 2���� ��� ArraList�� ����
				int index = 0;
				for (int x = 0; x < n; x++) {
					for (int y = 0; y < n; y++) {
						// �ߺ��� Ȯ���Ͽ� �迭�� ����
						binaryArray[0][index++] = (numArray[0][x] + numArray[1][y]);
					}
				}
				index = 0;
				// 2���� ��� ArraList�� ����
				for (int x = 0; x < n; x++) {
					for (int y = 0; y < n; y++) {
						// �ߺ��� Ȯ���Ͽ� �迭�� ����
						binaryArray[1][index++] = (numArray[2][x] + numArray[3][y]);
					}
				}
				// �迭�� ����
				Arrays.sort(binaryArray[1]);
				// algorithm
				for (int x = 0; x < binaryArray[0].length; x++) {
					int findNumber = k - binaryArray[0][x];
					int findIndex = Arrays.binarySearch(binaryArray[1], findNumber);
					// ���� ���� 1���� �����Ѵٸ� ������� ����ϰ� �ݺ����� �����Ѵ�.
					if (findIndex >= 0) {
						result = binaryArray[0][x] + binaryArray[1][findIndex];
						break;
					} else {
						// �������̶�� findIndex�� ����� ���ش�.
						findIndex = -1 * (findIndex + 1);
					}
					// findIndex�� 0�̶�� �ѹ��� Ž��
					if (findIndex == 0) {
						int temp = binaryArray[0][x] + binaryArray[1][0];
						if (Math.abs(k - temp) == Math.abs(k - result))
							result = temp < result ? temp : result;
						else
							result = Math.abs(k - temp) <= Math.abs(k - result) ? temp : result;
					} else if (findIndex == binaryArray[1].length) {
						findIndex--;
						int temp = binaryArray[0][x] + binaryArray[1][findIndex];
						if (Math.abs(k - temp) == Math.abs(k - result))
							result = temp < result ? temp : result;
						else
							result = Math.abs(k - temp) <= Math.abs(k - result) ? temp : result;
					} else {
						int temp = binaryArray[0][x] + binaryArray[1][findIndex];
						if (Math.abs(k - temp) == Math.abs(k - result))
							result = temp < result ? temp : result;
						else
							result = Math.abs(k - temp) <= Math.abs(k - result) ? temp : result;
						temp = binaryArray[0][x] + binaryArray[1][--findIndex];
						if (Math.abs(k - temp) == Math.abs(k - result))
							result = temp < result ? temp : result;
						else
							result = Math.abs(k - temp) <= Math.abs(k - result) ? temp : result;
					}
				}
				out.write(result + "\n");
				out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}