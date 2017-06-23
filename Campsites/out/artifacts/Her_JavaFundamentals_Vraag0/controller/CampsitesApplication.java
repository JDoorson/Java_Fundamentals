package controller;

import model.Wildernis;
import view.Knoppenbalk;
import view.OplossingView;
import view.Statusbalk;
import view.WildernisView;

import javax.swing.*;
import java.awt.BorderLayout;

/**
 * Created by Jamal on 30/05/2017.
 */
public class CampsitesApplication extends JFrame {
    private Wildernis model;

    public CampsitesApplication() {
        int dimension = setGridSize();
        model = new Wildernis(dimension);
        setBounds(100, 100, 800, 800);
        setLayout(new BorderLayout());
        setTitle("Campsites");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        new OplossingView(model);

        add(new Statusbalk(model), BorderLayout.NORTH);
        add(new WildernisView(model), BorderLayout.CENTER);
        add(new Knoppenbalk(model), BorderLayout.SOUTH);

        setVisible(true);
    }

    private int setGridSize() {
        int fieldSize;
        String input = (String) JOptionPane.showInputDialog(
                this, "Enter a grid size between 8 and 20",
                "Campsites - Size selection", JOptionPane.PLAIN_MESSAGE,
                null, null, null);

        try {
            fieldSize = Integer.parseInt(input);
            if (fieldSize >= 8 && fieldSize <= 20) {
                return fieldSize;
            } else {
                throw new Exception();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Numbers between 8 and 20 only!");
            return setGridSize();
        }
    }

    public static void main(String[] args) {
        new CampsitesApplication();
    }
}
