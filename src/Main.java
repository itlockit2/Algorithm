import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		int kill = scanner.nextInt();
		int temp = 1;
		Queue myque = new LinkedList();
		for(int i = 1 ; i <= number ; i++) {
			myque.offer(i);
		}
		System.out.print("<");
		while(!myque.isEmpty()) {
			if(temp == kill) {
				if(myque.size() == 1) {
					System.out.print(myque.remove());
				} else {
				System.out.print(myque.remove() +", ");
				temp = 1;
				}
			} else {
				myque.offer(myque.remove());
				temp++;
			}
		}
		System.out.print(">");
	}
}