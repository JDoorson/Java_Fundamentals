package Klok;

import javax.swing.*;
import java.util.Scanner;

/**
 * Created by Jamal on 03/02/2017.
 */
public class KlokApplicatie {
    public KlokApplicatie()
    {
        KlokModel model = new KlokModel(12, 0);
        KlokConsoleView view = new KlokConsoleView(model);

        Timer pulse = new Timer(1000, new PulseController(model));
        pulse.start();

        waitForEnter();
    }

    public static void main(String[] args)
    {
        new KlokApplicatie();
    }

    private void waitForEnter()
    {
        new Scanner( System.in ).nextLine();
        System.exit( 0 );
    }
}
