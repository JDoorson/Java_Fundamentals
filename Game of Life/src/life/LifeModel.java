package life;

import java.util.*;

public class LifeModel {
    private final int ROWS; // Rows first
    private final int COLS;
    private final int CHANCE; // % chance to set to ALIVE
    private boolean[][] grid; // true = ALIVE, false = DEAD

    public LifeModel(int rows, int cols, int chance) {
        ROWS = rows;
        COLS = cols;
        CHANCE = chance;
        grid = new boolean[ROWS][COLS];
        final Random gen = new Random();

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

    public boolean isLevend(int row, int col) {
        return grid[row][col];
    }

    private int telBuren(int row, int col) {
        int num = 0;

        for (int y = row - 1; y <= row + 1; y++) {
            if (y == -1 || y == ROWS) continue;
            for (int x = col - 1; x <= col + 1; x++) {
                if (x == -1 || x == COLS) continue;
                if (isLevend(y, x) && !(y == row && x == col)) num++;
            }
        }

        return num;
    }

    public void test(int numTests)
    {
        final Random gen = new Random();
        for(int i = 0; i<numTests; i++)
        {
            int row = gen.nextInt(ROWS);
            System.out.print("Row: " + row + "    ");

            int col = gen.nextInt(COLS);
            System.out.print("Col: " + col + "    ");

            System.out.println("Buren: " + telBuren(row, col));
        }
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

    public int getROWS() {
        return ROWS;
    }

    public int getCOLS() {
        return COLS;
    }

    public int getCHANCE() {
        return CHANCE;
    }
}
