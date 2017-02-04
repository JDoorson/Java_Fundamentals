package Klok;

import javax.swing.*;
/**
 * Created by Jamal on 03/02/2017.
 */
public class KlokApplicatie {

    public static void main(String[] args)
    {
        KlokModel model = new KlokModel(12, 0);
        KlokConsoleView view = new KlokConsoleView(model);

        Timer pulse = new Timer(1000, new PulseController(model));
        pulse.start();
    }
}
