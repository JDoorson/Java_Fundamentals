package life;

import java.util.Random;
import java.util.Observable;

public class LifeModel extends Observable {
    private final int X;
    private final int Y;
    private final int CHANCE; // % chance to set to ALIVE
    private boolean[][] grid; // true = ALIVE, false = DEAD

    public LifeModel(int columns, int rows, int chance) {
        X = columns;
        Y = rows;
        CHANCE = chance;
        grid = new boolean[X][Y];

        init();
    }

    private void init()
    {
        final Random gen = new Random();
        for (int x = 0; x < X; x++) {
            for (int y = 0; y < Y; y++) {
                //CHANCE% chance to set ALIVE (true), else DEAD (false)
                if (x == 0 || x == X - 1 || y == 0 || y == Y - 1 || gen.nextInt(100) >= CHANCE)
                    grid[x][y] = false;
                else
                    grid[x][y] = true;
            }
        }
    }

    public void volgendeGeneratie() {
        boolean[][] newGrid = new boolean[X][Y];
        for (int x = 1; x < X -1; x++) {
            for (int y = 1; y < Y -1; y++)
                newGrid[x][y] = evolve(x, y);
        }
        replaceGrid(newGrid);
        setChanged();
        notifyObservers();
    }

    private void replaceGrid(boolean[][] newGrid) {
        for (int x = 0; x < X; x++) {
            for (int y = 0; y < Y; y++)
                grid[x][y] = newGrid[x][y];
        }
    }

    public boolean isLevend(int x, int y) {
        return grid[x][y];
    }

    private int telBuren(int x, int y) {
        int num = 0;

        for (int _x = x - 1; _x <= x + 1; _x++) {
            for (int _y = y - 1; _y <= y + 1; _y++) {
                if (isLevend(_x, _y)) num++;
            }
        }

        return num;
    }

    private boolean evolve(int x, int y) {
        int buren = telBuren(x, y);
        boolean isLevend = isLevend(x, y);
        if (isLevend) return !(buren < 3 || buren > 4); //+1 omdat de cel zelf ook geteld wordt
        else return buren == 3;
    }

    public void test(int numTests) {
        final Random gen = new Random();
        for (int i = 0; i < numTests; i++) {
            int row = gen.nextInt(X);
            System.out.print("Row: " + row + "    ");

            int col = gen.nextInt(Y);
            System.out.print("Col: " + col + "    ");

            System.out.println("Buren: " + telBuren(row, col));
            System.out.println("Oud: " + isLevend(row, col) + "    nieuw: " + evolve(row, col));
        }
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }
}
