import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Jamal on 16/03/2017.
 */
public class Statusbalk extends JPanel implements Observer {
    //private int bom = 0, boot = 0;
    private Zee model;
    private JLabel botenLabel, bommenLabel;

    public Statusbalk(Zee model) {
        this.model = model;
        addModelObservers();
        setLayout(new GridLayout());
        setLayout(new GridLayout(1, 2));
        botenLabel = new JLabel("Boten gezonken: 0");
        add(botenLabel);
        bommenLabel = new JLabel();
        add(bommenLabel);
    }

    /**
     * Subscribed op alle vakjes
     */
    private void addModelObservers()
    {
        final Vakje[][] grid = model.getGrid();
        for (int row = 1; row < model.getROWS() - 1; row++) {
            for (int col = 1; col < model.getCOLS() - 1; col++) {
                grid[row][col].addObserver(this);
            }
        }
    }

    /**
     * Edit de tekst in de labels als dit nodig is
     */
    private void editBoten()
    {
        int gezonken = 0;
        ArrayList<Boot> boten = model.getBoten();
        for(Boot b : boten)
        {
            if(b.isGezonken())
                gezonken++;
        }
        if(gezonken < 5)
            botenLabel.setText("Boten gezonken: " + gezonken);
        else {
            botenLabel.setText("Boten gezonken: " + gezonken + " GAME OVER");
            bommenLabel.setText("Bommen gebruikt: " + model.telBommen());
        }
    }

    public void update(Observable obs, Object obj) {
        editBoten();
    }
}
