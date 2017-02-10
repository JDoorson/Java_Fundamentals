package life;

import javax.swing.Timer;
import java.util.Scanner;

public class LifeApplication {

    public static void main(String[] args) {
        LifeModel model = new LifeModel(30, 20, 10);
        LifeConsoleView view = new LifeConsoleView(model);

        //Laat nu niet de eerste generatie zien

        Timer pulse = new Timer(1000, new PulseController(model));
        pulse.start();

        waitForEnter();
    }

    private static void waitForEnter()
    {
        new Scanner( System.in ).nextLine();
        System.exit( 0 );
    }
}
