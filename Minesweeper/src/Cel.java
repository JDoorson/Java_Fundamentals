/**
 * Created by Jamal on 09/03/2017.
 */
public class Cel {
    private final int ROW, COL;
    private int value;
    private boolean isFlagged, isBomb;

    public Cel(int row, int col) {
        ROW = row;
        COL = col;
        value = -1;
        isFlagged = false;
        isBomb = false;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }

    public boolean isBomb() {
        return isBomb;
    }

    public void setBomb() {
        isBomb = true;
    }

    public void setFlagged(boolean isFlagged) {
        this.isFlagged = isFlagged;
    }
}
