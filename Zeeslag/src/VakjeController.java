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

    /**
     * Mouseclicked voor het revealen zodat je de muis nog weg kan trekken
     * @param e
     */
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1 && !vakje.marked && !vakje.bekend)
            vakje.reveal();
    }

    /**
     * MouseReleased omdat het plaatsen van vlaggen ongedaan kan worden
     * @param e
     */
    public void mouseReleased(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON3 && !vakje.bekend)
            vakje.mark();
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }
}
