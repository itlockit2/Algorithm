package palindrome;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		char[] chr = str.toCharArray();
		for(int i = 0 ; i< chr.length/2; i++) {
			if(chr[i] != chr[chr.length-i-1]) {
				System.out.println(0);
				return;
			}
		}
		System.out.println(1);
	}
}
