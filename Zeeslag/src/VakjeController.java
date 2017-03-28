import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Jamal on 16/03/2017.
 */
public class VakjeController implements MouseListener {
    private Vakje vakje;

    public VakjeController(Vakje vakje) {
        this.vakje = vakje;
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1 && !vakje.marked && !vakje.bekend)
            vakje.reveal();
    }

    public void mouseReleased(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON3 && !vakje.bekend)
            vakje.mark();
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }
}
