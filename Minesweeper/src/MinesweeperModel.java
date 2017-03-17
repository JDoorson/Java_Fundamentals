import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

/**
 * Created by Jamal on 10/03/2017.
 */
public class MinesweeperModel extends Observable {
    private Cel[][] grid;
    private final int ROWS, COLS, CHANCE;

    private ArrayList<Cel> bombs;

    /**
     * Constructor.
     * Increments the number of given rows and columns by 2 to make checking neighbours easier. These extra rows
     * and columns are not used, nor are they displayed.
     *
     * @param rows   Number of rows in the grid
     * @param cols   Number of columns in the grid
     * @param chance % chance of a cel to become a bomb on creation
     */
    public MinesweeperModel(int rows, int cols, int chance) {
        ROWS = rows + 2;
        COLS = cols + 2;
        CHANCE = chance;
        bombs = new ArrayList<>();
        init();
    }

    /**
     * Initializes the grid and fills it with bombs, calls assignValue on all cells.
     * Outer edges of the grid are ignored.
     */
    private void init() {
        grid = new Cel[ROWS][COLS];
        final Random rng = new Random();

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (isVisible(row, col) && rng.nextInt(100) < CHANCE) {
                    Cel c = new Cel(row, col);
                    grid[row][col] = c;
                    c.setBomb();
                    bombs.add(c);
                }
                else
                    grid[row][col] = new Cel(row, col);
            }
        }

        for (int row = 1; row < ROWS - 1; row++) {
            for (int col = 1; col < COLS - 1; col++) {
                if (!grid[row][col].isBomb())
                    assignValue(row, col);
            }
        }
    }

    /**
     * Checks the surrounding cells of the given location, then gives each cel a value that represents
     * the number of bombs surrounding each cel.
     *
     * @param row Row of the center cel
     * @param col Column of the center cel
     */
    private void assignValue(int row, int col) {
        int value = 0;
        for (int pRow = row - 1; pRow <= row + 1; pRow++) {
            for (int pCol = col - 1; pCol <= col + 1; pCol++) {
                if (grid[pRow][pCol].isBomb())
                    value++;
            }
        }
        grid[row][col].setValue(value);
    }

    /**
     * Checks if the given cel is in the visible part of the grid
     * @param row Row of the given cel
     * @param col Column of the given cel
     * @return True if the cel is in the visible part of the grid, false otherwise
     */
    private boolean isVisible(int row, int col) {
        return row != 0 && row != ROWS - 1 && col != 0 && col != COLS - 1;
    }

    public int getROWS() {
        return ROWS;
    }

    public int getCOLS() {
        return COLS;
    }

    public Cel[][] getGrid() {
        return grid;
    }

    public Cel getGridCel(int row, int col)
    {
        return grid[row][col];
    }

    public ArrayList<Cel> getBombs()
    {
        return bombs;
    }
}
