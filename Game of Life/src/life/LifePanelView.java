package life;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Jamal on 16/02/2017.
 */
public class LifePanelView extends JPanel implements Observer {
    private JButton[][] btnGrid;
    private LifeModel model;

    public LifePanelView(LifeModel model) {
        btnGrid = new JButton[model.getX() - 2][model.getY() - 2];
        this.model = model;
        model.addObserver(this);
        setLayout(new GridLayout(model.getY() - 2, model.getX() - 2));

        for (int y = 1; y < model.getY() - 1; y++) {
            for (int x = 1; x < model.getX() - 1; x++) {
                if (model.isLevend(x, y)) {
                    //add(new JButton("X"));
                    JButton btn = new JButton("X");
                    btnGrid[x - 1][y - 1] = btn;
                    add(btn);
                } else {
                    //add(new JButton("."));
                    JButton btn = new JButton(".");
                    btnGrid[x - 1][y - 1] = btn;
                    add(btn);
                }
            }
        }
    }

    private void refresh() {
        //Create button grid on creation
        //Use grid to edit the text
        for (int y = 0; y < btnGrid[0].length; y++) {
            for (int x = 0; x < btnGrid.length; x++) {
                if(model.isLevend(x+1, y+1))
                    btnGrid[x][y].setText("X");
                else
                    btnGrid[x][y].setText(".");
            }
        }
    }

    public void update(Observable model, Object info) {
        refresh();
    }
}
