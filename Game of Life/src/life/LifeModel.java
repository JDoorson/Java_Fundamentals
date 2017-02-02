package life;

import java.util.*;

public class LifeModel {
	private final int ROWS; // Rows first
	private final int COLS;
	private final int CHANCE = 10; // % chance to set to ALIVE
	private boolean[][] grid; // true = ALIVE, false = DEAD

	public LifeModel(int rows, int cols) {
		ROWS = rows;
		COLS = cols;		
		grid = new boolean[ROWS][COLS];
		Random gen = new Random();

		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				// 10% chance to set ALIVE, else DEAD
				if (row == 0 || row == ROWS - 1 || col == 0 || col == COLS - 1 || gen.nextInt(100) >= CHANCE)
					grid[row][col] = false;
				else
					grid[row][col] = true;
			}
		}
	}

	private boolean isLevend(int row, int col) {
		return grid[row][col];
	}

	public void print() {
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				if (isLevend(row, col))
					System.out.print("X ");
				else
					System.out.print(". ");
			}
			System.out.println();
		}
	}
}
