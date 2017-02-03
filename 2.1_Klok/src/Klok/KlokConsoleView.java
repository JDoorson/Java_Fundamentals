package Klok;
import javax.swing.*;
/**
 * Created by Jamal on 03/02/2017.
 */
public class KlokConsoleView {
    private KlokModel model;

    public KlokConsoleView(KlokModel model)
    {
        this.model = model;
    }

    public void refresh()
    {
        System.out.println(model.getHour() + " uren en " + model.getMin() + " minuten.");
    }
}
