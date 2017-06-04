package view;

import model.Vakje;

import javax.swing.JPanel;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Jamal on 30/05/2017.
 */
public abstract class VakjeView extends JPanel {
    public VakjeView()
    {
        setBackground(Color.LIGHT_GRAY);
    }
}
