import javax.swing.JButton;
import java.util.ArrayList;

/**
 * Created by Jamal on 09/03/2017.
 */
public class Cel extends JButton {
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

    public void reveal(MinesweeperModel model) {
        setEnabled(false);

        if (isBomb()) {
            setText("\uD83D\uDCA3");
        } else {
            setText(String.valueOf(value));
        }
    }

    private void cascade(MinesweeperModel model, ArrayList<Cel> checked) {
        for (int row = ROW - 1; row <= ROW + 1; row++) {
            for (int col = COL - 1; col <= COL + 1; col++) {
                Cel c = model.getGridCel(row, col);
                if (!checked.contains(c)) {
                    c.reveal(model);
                }
            }
        }
    }

    public void flag() {
        isFlagged = !isFlagged;

        if (isFlagged)
            setText("\uD83D\uDEA9");
        else
            setText("");
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
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

    public boolean isFlagged() {
        return isFlagged;
    }

    public int getROW() {
        return ROW;
    }

    public int getCOL() {
        return COL;
    }
}
