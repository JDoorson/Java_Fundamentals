package view;

import model.Gras;
import model.Vakje;
import model.Wildernis;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jamal on 30/05/2017.
 */
public class Knoppenbalk extends JPanel {
    private Wildernis model;
    private JButton btnReveal = new JButton("Reveal");
    private JButton btnReset = new JButton("Reset");

    public Knoppenbalk(Wildernis model) {
        this.model = model;

        setLayout(new GridLayout(1, 4));

        add(btnReveal);
        add(btnReset);
        add(new JButton("Button3"));
        add(new JButton("Button4"));

        btnReveal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                markNeighbourless();
            }
        });

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
            }
        });
    }

    private void reset() {
        Vakje[][] grid = model.getGrid();

        for (int x = 1; x < model.getGrootte(); x++) {
            for (int y = 1; y < model.getGrootte(); y++) {
                if (grid[x][y] instanceof Gras)
                    ((Gras) grid[x][y]).reset();
            }
        }
    }

    private void markNeighbourless() {
        Vakje[][] grid = model.getGrid();

        for (int x = 1; x < model.getGrootte(); x++) {
            for (int y = 1; y < model.getGrootte(); y++) {
                if (grid[x][y] instanceof Gras && ((Gras) grid[x][y]).getBoomBuren().isEmpty())
                    ((Gras) grid[x][y]).setGras();
            }
        }
    }
}
