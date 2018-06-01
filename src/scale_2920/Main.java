package scale_2920;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int findAscending [] = {1,2,3,4,5,6,7,8};
		int findDeceding [] = {8,7,6,5,4,3,2,1};
		
		int numArray[] = new int [8];
		for(int i = 0 ;  i < 8 ; i++) {
			numArray[i] = scanner.nextInt();
		}
		
		if(Arrays.equals(numArray, findAscending)) {
			System.out.println("ascending");
		} else if(Arrays.equals(numArray, findDeceding)) {
			System.out.println("descending");
		} else {
			System.out.println("mixed");
		}
		
	}

}
