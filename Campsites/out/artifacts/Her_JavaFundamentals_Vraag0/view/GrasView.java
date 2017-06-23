package view;

import java.awt.Color;

import controller.VakjeController;
import model.Gras;
import model.Mark;
import model.Vakje;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Jamal on 30/05/2017.
 */
public class GrasView extends VakjeView implements Observer {
    private Gras vakje;

    public GrasView(Gras vakje)
    {
        super();
        this.vakje = vakje;
        this.vakje.addObserver(this);
        addMouseListener(new VakjeController(vakje));
    }

    public void update(Observable obs, Object obj) {
        if(vakje.getMarkering() == Mark.GRASS)
            setBackground(Color.GREEN);
        else if(vakje.getMarkering() == Mark.TENT)
            setBackground(Color.ORANGE);
        else
            setBackground(Color.LIGHT_GRAY);
    }
}
