package Klok;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jamal on 04/02/2017.
 */
public class PulseController implements ActionListener {
    private KlokModel model;

    public PulseController(KlokModel model)
    {
        this.model = model;
    }

    @Override public void actionPerformed(ActionEvent event)
    {
        model.volgendeMinuut();
    }
}
