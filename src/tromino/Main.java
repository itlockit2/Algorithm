package tromino;

public class Main {

	static int[][] grid;
	static int currentNum;

	static void tromino(int size, int x, int y) {
		grid = new int[size][size];
		grid[x][y] = -1;
		currentNum = 1;

		tileRec(size, 0, 0);

	}

	static void tileRec(int size, int topX, int topY) {
		if (size == 2) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					if (grid[topX + i][topY + j] != 0) {
						continue;
					}
					grid[topX + i][topY + j] = currentNum;
				}
			}
			currentNum++;
			return;
		}
		//
		int holeX = topX;
		int holeY = topY;

		OUTER:
		for (; holeX < topX + size; holeX++) {
			holeY = topY;
			for(; holeY < topY + size ; holeY++) {
				if(grid[holeX][holeY] != 0) {
					break OUTER;
				}
			}
		}
	}

	public static void main(String[] args) {

	}

}
