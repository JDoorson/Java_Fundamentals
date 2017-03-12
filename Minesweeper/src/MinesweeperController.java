import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Jamal on 12/03/2017.
 */
public class MinesweeperController implements MouseListener {
    public MinesweeperController() {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
        Cel btn = (Cel) e.getSource();
        if (e.getButton() == MouseEvent.BUTTON1)
            btn.reveal();
    }

    public void mouseReleased(MouseEvent e) {
        Cel btn = (Cel) e.getSource();
        if (e.getButton() == MouseEvent.BUTTON3)
            btn.flag();
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

}
