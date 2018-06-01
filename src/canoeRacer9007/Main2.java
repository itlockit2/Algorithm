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
			// 테스트 케이스의 개수
			int T = Integer.parseInt( st.nextToken());
			for (int i = 0; i < T; i++) {
				// 리스트 초기화
				ArrayList<Integer> list_1 = new ArrayList<>();
				ArrayList<Integer> list_2 = new ArrayList<>();
				int result = 0;
				
				st = new StringTokenizer( br.readLine() );
				// 카누의 값
				int k = Integer.parseInt( st.nextToken() );
				// 한 클래스의 학생수
				int n = Integer.parseInt( st.nextToken() );
				int numArray[][] = new int[n][4];
				for (int x = 0; x < 4; x++) {
					st = new StringTokenizer( br.readLine() );
					for (int y = 0; y < n; y++) {
						numArray[y][x] = Integer.parseInt( st.nextToken());
					}
				}
				// 2개씩 섞어서 ArraList에 대입
				for (int x = 0; x < n; x++) {
					for (int y = 0; y < n; y++) {
						// 중복을 확인하여 배열에 대입
							list_1.add(numArray[x][0] + numArray[y][1]);
					}
				}
				// 2개씩 섞어서 ArraList에 대입
				for (int x = 0; x < n; x++) {
					for (int y = 0; y < n; y++) {
						// 중복을 확인하여 배열에 대입
							list_2.add(numArray[x][2] + numArray[y][3]);
					}
				}
				// 배열을 정렬
				//Arrays.sort(list_1);
				//Arrays.sort(list_2);
				// algorithm
				for (int x = 0; x < list_1.size(); x++) {
					int findNumber = k - list_1.get(x);
					int findIndex = Collections.binarySearch(list_2, findNumber);
					// 만약 합이 2번째 리스트에 존재한다면 결과값을 계산하고 반복문을 종료한다.
					if (findIndex >= 0) {
						result = k;
						break;
						// 존재하지 않는다면
					} else {
						// 들어갈 인덱스의 위치를 계산한다.
						findIndex = (-1 * findIndex) - 1;
						// 반복 하기 위한 변수를 설정한다.
						int iterator;
						// 들어갈 값이 리스트에 있는 값보다 가장 작거나 가장 큰경우 그 인덱스만 탐색한다.
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
							// 두수의 차가 더 적은쪽이 결과값이다.
							if (Math.abs(k - temp) < Math.abs(k - result)) {
								result = temp;
								// 만약 두수의 차가 같다면 작은수가 결과값이다.
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
