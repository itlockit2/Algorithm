package find_Alphabet_10809;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		int num[] = new int[str.length()];
		int find[] = new int[26];
		for(char i = 'a', j = 0 ; i <= 'z' ; i++,j++) {
			find[j] = i;
		}
		for(int i = 0 ; i < str.length() ; i++) {
			num[i] = (int)str.charAt(i);
		}
		OUTER:
		for(int i = 0; i < find.length ; i++) {
			for(int j = 0; j < num.length ; j++) {
				if(find[i] == num[j]) {
					System.out.print(j + " ");
					continue OUTER;
				}
			}
			System.out.print(-1 + " ");
		}
	}

}
