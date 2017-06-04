package view;

import model.Boom;

import java.awt.Color;

/**
 * Created by Jamal on 30/05/2017.
 */
public class BoomView extends VakjeView {
    private Boom vakje;

    public BoomView(Boom vakje)
    {
        super();
        this.vakje = vakje;
        setBackground(Color.BLUE);
    }
}
