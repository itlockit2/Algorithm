package hanoiTower;

public class Main {
	public static void moveDisk(int n, char src, char inter, char dest) {
		System.out.println(" n = " + n + " src = " + src + " inter =  " + inter + " dest = " + dest);
		if (n == 0) {
			return;
		}
		moveDisk(n-1 ,src,dest,inter);
		System.out.println("After moveDisk1 n = " + n + " src = " + src +  " dest = " + dest);
		moveDisk(n-1 ,inter,src,dest);
	}

	public static void main(String[] args) {
		moveDisk(3,'A','B','C');
	}

}
