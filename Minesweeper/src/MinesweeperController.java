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
        //c.setEnabled(false);

        if (c.isBomb()) {
            c.setEnabled(false);
            c.setText("\uD83D\uDCA3");
            gameOver();
        } else {
            if(c.getValue() == 0)
            {
                revealSurrounding(c);
            }
            else{
                c.setEnabled(false);
                c.setText(String.valueOf(c.getValue()));
            }
        }
    }

    private void revealSurrounding(Cel c)
    {
        final int ROW = c.getROW(), COL = c.getCOL();
        //if(ROW < 1 || ROW > model.getROWS() || COL < 1 || ROW > model.getCOLS()) return;

        if(c.getValue() == 0 && c.isEnabled())
        {
            c.setEnabled(false);
            for(int row = ROW-1; row <= ROW+1; row++)
            {
                for(int col = COL-1; col <= COL+1; col++)
                    reveal(model.getGridCel(row, col));
            }
        }
    }

    public void flag(Cel c) {
        c.setFlagged(!c.isFlagged());

        if (c.isFlagged())
            c.setText("\uD83D\uDEA9");
        else
            c.setText("");
    }

    private void gameOver()
    {

    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
        Cel c = (Cel) e.getSource();
        if (e.getButton() == MouseEvent.BUTTON1 && c.isEnabled())
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
