package life;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jamal on 10/02/2017.
 */
public class PulseController implements ActionListener {
    private LifeModel model;

    public PulseController(LifeModel model)
    {
        this.model = model;
    }

    @Override public void actionPerformed(ActionEvent event)
    {
        model.volgendeGeneratie();
    }
}