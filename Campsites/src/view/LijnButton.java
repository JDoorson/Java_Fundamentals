package view;

import model.Gras;
import model.Mark;
import model.Vakje;
import model.Wildernis;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Jamal on 30/05/2017.
 */
public abstract class LijnButton extends JButton implements Observer {
    protected int lijn;
    protected int placedTents;
    protected int maxTents;
    protected Wildernis model;

    protected abstract int getAantal();
    protected abstract void checkLine();
    protected abstract boolean isComplete();
    protected abstract void fillWithGrass();
    protected abstract void resetLine();

    public LijnButton(int lijn, Wildernis model) {
        this.lijn = lijn;
        this.model = model;
        placedTents = 0;
        maxTents = getAantal();
        setText(maxTents + "");
        setFont(getFont().deriveFont(Font.BOLD));
        setTextColor();

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkLine();
            }
        });
    }

    public void update(Observable obs, Object obj) {
        if (obj != null)
            placedTents += (int) obj;

        setTextColor();
    }

    private void setTextColor()
    {
        if(placedTents < maxTents)
            setForeground(Color.BLACK);
        else if(maxTents == placedTents)
            setForeground(Color.GREEN);
        else if(placedTents > maxTents)
            setForeground(Color.RED);
    }
}
