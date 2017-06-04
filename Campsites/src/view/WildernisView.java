package view;

import model.Boom;
import model.Gras;
import model.Vakje;
import model.Wildernis;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Color;

/**
 * Created by Jamal on 30/05/2017.
 */
public class WildernisView extends JPanel {
    private Wildernis model;

    public WildernisView(Wildernis model) {
        this.model = model;

        setLayout(new GridLayout(model.getGrootte(), model.getGrootte(), 1, 1));
        setBackground(Color.GREEN);

        addVakjeViews();
    }

    public void addVakjeViews() {
        Vakje[][] grid = model.getGrid();
        for (int x = 1; x < model.getGrootte(); x++) {
            for (int y = 1; y < model.getGrootte(); y++) {
                if (grid[x][y] instanceof Boom)
                    add(new BoomView((Boom) grid[x][y]));
                else
                    add(new GrasView((Gras) grid[x][y]));
            }
            add(new RijButton(x, model));
        }

        for(int y = 1; y < model.getGrootte(); y++)
            add(new KolomButton(y, model));
    }
}
