package view;

import model.Wildernis;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;

/**
 * Created by Jamal on 30/05/2017.
 */
public class Statusbalk extends JPanel{
    private Wildernis model;

    public Statusbalk(Wildernis model){
        this.model = model;
        setLayout(new GridLayout(1, 2));
        add(new JLabel("Label 1"));
        add(new JLabel("Label 2"));
    }
}
