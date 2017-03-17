import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Jamal on 16/03/2017.
 */
public class Zee {
    private final int ROWS, COLS;
    private Vakje[][] grid;
    private ArrayList<Boot> boten;

    public Zee(int rows, int cols) {
        ROWS = rows + 2;
        COLS = cols + 2;
        grid = new Vakje[ROWS][COLS];

        vulOpMetWater();
    }

    private void plaatsBoot(int lengte) {
        Random rng = new Random();
        ArrayList<BootVakje> boot = new ArrayList<>();

        int startCol;// = rng.nextInt(COLS - lengte - 2) + 1; //Bound: -1 or -2?
        int startRow;// = rng.nextInt(ROWS - 2) + 1;

        do {
            startCol = rng.nextInt(COLS - lengte - 2) + 1; //Bound: -1 or -2?
            startRow = rng.nextInt(ROWS - 2) + 1;
        } while (!verifyPlacementH(startRow, startCol, lengte));


    }

    private ArrayList<BootVakje> maakBootH(int row, int startCol, int length)
    {
        ArrayList<BootVakje> boot = new ArrayList<>();

        for(int col = startCol; col < startCol+length; col++) {
            grid[row][col] = new BootVakje();
            boot.add((BootVakje)grid[row][col]);
        }

        return boot;
    }

    private boolean verifyPlacementH(int startRow, int startCol, int length) {
        if (grid[startRow][startCol] instanceof BootVakje
                || grid[startRow][startCol + length] instanceof BootVakje) {
            return false;
        }

        for (int row = startRow - 1; row <= startRow + 1; row += 2) {
            for (int col = startCol - 1; col < startCol + length; col++) {
                if (grid[row][col] instanceof BootVakje)
                    return false;
            }
        }

        return true;
    }

    private void vulOpMetWater() {
        for (int row = 1; row < ROWS - 1; row++) {
            for (int col = 1; col < COLS - 1; col++) {
                if (grid[row][col] == null)
                    grid[row][col] = new Vakje();
            }
        }
    }

    public int getROWS() {
        return ROWS;
    }

    public int getCOLS() {
        return COLS;
    }

    public Vakje[][] getGrid() {
        return grid;
    }
}
