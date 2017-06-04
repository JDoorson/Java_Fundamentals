package controller;

import model.Gras;
import model.Vakje;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Jamal on 30/05/2017.
 */
public class VakjeController implements MouseListener {
    private Gras v;

    public VakjeController(Gras v) {
        this.v = v;
    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            v.markAsTent();
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            v.markAsGras();
        }
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseClicked(MouseEvent e) {

    }
}
