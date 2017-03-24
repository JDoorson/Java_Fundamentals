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
        boten = new ArrayList<>();

        plaatsBoot(5);
        plaatsBoot(4);
        plaatsBoot(3);
        plaatsBoot(2);
        plaatsBoot(2);
        vulOpMetWater();
    }

    private void plaatsBoot(int lengte) {
        Random rng = new Random();
        ArrayList<BootVakje> boot;

        if (rng.nextInt(2) == 0)
            boot = maakBootVerticaal(lengte, rng);
        else
            boot = maakBootHorizontaal(lengte, rng);

        boten.add(new Boot(boot));
    }

    private ArrayList<BootVakje> maakBootVerticaal(int lengte, Random rng) {
        //Vindt een passende startpositie
        int startRow, startCol;
        do {
            startCol = rng.nextInt(COLS - 2) + 1;
            startRow = rng.nextInt(ROWS - lengte - 1) + 1;
        } while (!verifyPlacementVertical(startRow, startCol, lengte));

        //Maak de BootVakjes aan in 't grid, en de boot aan de boten
        ArrayList<BootVakje> boot = new ArrayList<>();
        for (int row = startRow; row < startRow + lengte; row++) {
            grid[row][startCol] = new BootVakje();
            boot.add((BootVakje) grid[row][startCol]);
        }

        return boot;
    }

    private ArrayList<BootVakje> maakBootHorizontaal(int lengte, Random rng) {
        //Vindt een passende startpositie
        int startRow, startCol;
        do {
            startCol = rng.nextInt(COLS - lengte - 1) + 1;
            startRow = rng.nextInt(ROWS - 2) + 1; //Waarom Col-1, Row-2?
        } while (!verifyPlacementHorizontal(startRow, startCol, lengte));

        //Maak de BootVakjes aan in 't grid, en de boot aan de boten
        ArrayList<BootVakje> boot = new ArrayList<>();
        for (int col = startCol; col < startCol + lengte; col++) {
            grid[startRow][col] = new BootVakje();
            boot.add((BootVakje) grid[startRow][col]);
        }

        return boot;
    }

    private boolean verifyPlacementVertical(int startRow, int startCol, int length) {
        if (grid[startRow - 1][startCol] instanceof BootVakje
                || grid[startRow + length][startCol] instanceof BootVakje) {
            return false;
        }

        for (int row = startRow - 1; row <= startRow + length; row++) {
            for (int col = startCol - 1; col <= startCol + 1; col += 2) {
                if (grid[row][col] instanceof BootVakje)
                    return false;
            }
        }

        return true;
    }

    private boolean verifyPlacementHorizontal(int startRow, int startCol, int length) {
        if (grid[startRow][startCol - 1] instanceof BootVakje
                || grid[startRow][startCol + length] instanceof BootVakje) {
            return false;
        }

        for (int row = startRow - 1; row <= startRow + 1; row += 2) {
            for (int col = startCol - 1; col <= startCol + length; col++) {
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
