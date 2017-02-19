package life;

import javax.swing.Timer;
import java.util.Scanner;
import javax.swing.JFrame;

public class LifeApplication extends JFrame {
    private LifeModel model;
    public LifeApplication()
    {
        model = new LifeModel(30, 20, 10);
        LifeConsoleView view = new LifeConsoleView(model);

        frameStuff();
        //Laat nu niet de eerste generatie zien

        Timer pulse = new Timer(1000, new PulseController(model));
        pulse.start();

        waitForEnter();
    }

    public static void main(String[] args) {
        new LifeApplication();
    }

    private void frameStuff()
    {
        setBounds(100,100,350,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Game of Life");
        add(new LifePanelView(model));
        setVisible(true);
    }

    private static void waitForEnter()
    {
        new Scanner( System.in ).nextLine();
        System.exit( 0 );
    }
}
