import java.util.ArrayList;

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
