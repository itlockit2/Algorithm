package permutation_graph_9463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// 결과를 출력할 count 변수
	static long count = 0;

	static void mergeSort(int[] arr) {
		// 임시 저장 공간을 할당시켜준다
		int[] temp = new int[arr.length];
		// 재귀호출로 처음부터 끝까지 탐색시작한다.
		mergeSort(arr, temp, 0, arr.length - 1);
	}

	static void mergeSort(int[] arr, int[] temp, int start, int end) {
		// 시작점이 끝보다 작을때만 반으로 잘라 다시 재귀호출
		if (start < end) {
			int mid = (start + end) / 2;
			// 절반에서 앞부분 정렬
			mergeSort(arr, temp, start, mid);
			// 절반 뒷부분 정렬
			mergeSort(arr, temp, mid + 1, end);
			// 정렬후 합병
			merge(arr, temp, start, mid, end);
		}
	}

	static void merge(int[] arr, int[] temp, int start, int mid, int end) {
		// 임시배열에 start 부터 end까지 복사를 해준다
		for (int i = start; i <= end; i++) {
			temp[i] = arr[i];
		}
		// 2개의 배열중 하나의 배열 시작점은 start이고 하나의 배열 시작점은 mid + 1이다.
		int part1 = start;
		int part2 = mid + 1;
		// 정렬할 인덱스
		int index = start;
		// part1이 mid를 넘는다면 part1은 이제 정렬할 데이터가 없고
		// part2 또한 end를 넘는다면 정렬할 데이터가 없는것이다.
		while (part1 <= mid && part2 <= end) {
			// 만약 앞에가 더 작다면
			if (temp[part1] <= temp[part2]) {
				// 원본에 앞에있는 데이터를 넣어준다
				arr[index] = temp[part1];
				part1++;
			} else {
				// 원본에 뒤에있는 데이터를 넣어준다.
				arr[index] = temp[part2];
				part2++;
				// 이때 count를 part1의 남은개수 만큼 증가시켜준다.
				count = count + (mid - part1 + 1);
			}
			// index는 항상 1 증가한다.
			index++;
		}
		// 만약 part1의 데이터가 남아 있다면 넣어준다
		for (int i = 0; i <= mid - part1; i++) {
			arr[index + i] = temp[part1 + i];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 테스트 케이스 입력

		final int T = Integer.parseInt(st.nextToken());
		// 테스트 케이스만큼 반복
		for (int i = 0; i < T; i++) {
			// 배열의 크기 입력
			st = new StringTokenizer(br.readLine());
			final int N = Integer.parseInt(st.nextToken());
			// 원래 순열 선언 및 입력
			int array[] = new int[N];
			int array2[] = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				array[j] = Integer.parseInt(st.nextToken()) - 1;
			}

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				array2[j] = Integer.parseInt(st.nextToken()) - 1;
			}
			// 순열을 재구성
			int temp[] = new int[N];
			for (int j = 0; j < N; j++) {
				temp[array[j]] = j;
			}
			int temp2[] = new int[N];
			for (int j = 0; j < N; j++) {
				temp2[j] = temp[array2[j]];
			}
			// 합병정렬후 count 수 출력
			count = 0;
			mergeSort(temp2);
			System.out.println(count);

		}
	}
}
