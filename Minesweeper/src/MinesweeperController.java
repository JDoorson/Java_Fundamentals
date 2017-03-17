import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Jamal on 12/03/2017.
 */
public class MinesweeperController implements MouseListener {
    MinesweeperModel model;

    public MinesweeperController(MinesweeperModel model) {
        this.model = model;
    }

    private void reveal(Cel c) {
        if (c.isBomb()) {
            c.setEnabled(false);
            c.setText("\uD83D\uDCA3");
            c.setBackground(Color.RED);
            gameOver();
        } else if (c.getValue() == 0) {
            if (c.isEnabled()) {
                c.setEnabled(false);
                for (int row = c.getROW() - 1; row <= c.getROW() + 1; row++) {
                    for (int col = c.getCOL() - 1; col <= c.getCOL() + 1; col++)
                        reveal(model.getGridCel(row, col));
                }
            }
        } else {
            c.setEnabled(false);
            c.setText(String.valueOf(c.getValue()));
        }
    }

    public void flag(Cel c) {
        c.setFlagged(!c.isFlagged());

        if (c.isFlagged())
            c.setText("\uD83D\uDEA9");
        else
            c.setText("");
    }

    private void gameOver() {
        for (Cel bomb : model.getBombs()) {
            if (!bomb.isFlagged()) {
                bomb.setEnabled(false);
                bomb.setText("\uD83D\uDCA3");
            }
        }
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
        Cel c = (Cel) e.getSource();
        if (e.getButton() == MouseEvent.BUTTON1 && c.isEnabled() && !c.isFlagged())
            reveal(c);
    }

    public void mouseReleased(MouseEvent e) {
        Cel c = (Cel) e.getSource();
        if (e.getButton() == MouseEvent.BUTTON3 && c.isEnabled())
            flag(c);
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

}
