import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Jamal on 16/03/2017.
 */
public class VakjeController implements MouseListener {
    private VakjeView view;

    public VakjeController(VakjeView view) {
        this.view = view;
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1 && !view.getVakje().marked && !view.getVakje().bekend)
            view.getVakje().reveal();
    }

    public void mouseReleased(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON3 && !view.getVakje().bekend)
            view.getVakje().mark();
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }
}
