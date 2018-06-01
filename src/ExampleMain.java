import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExampleMain {

	public static List<Integer> getPrimeNumbers(int k){
		List<Integer> primes = new ArrayList<>();
		if(k < 2) {
			return primes;
		}
		primes.add(2);
		
		NEXT_NUMBER:
		for(int n = 3; n <= k; n+=2) {
			for( int i : primes) {
				if(n% i == 0) {
					continue NEXT_NUMBER;
				}
			}
			primes.add(n);
		}
		return primes;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		List <Integer> temp = getPrimeNumbers(N);
		System.out.println(temp);
	}

}
