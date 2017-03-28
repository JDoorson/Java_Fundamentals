import javax.swing.JFrame;

/**
 * Created by Jamal on 16/03/2017.
 */
public class ZeeslagApplication extends JFrame {
    public ZeeslagApplication() {
        setBounds(100,100,500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Zeeslag");

        Zee model = new Zee(10, 10);
        new OplossingView(model);
        add(new ZeeView(model));
        setVisible(true);
    }

    public static void main(String[] args) {
        new ZeeslagApplication();
    }

    private void testOplossing()
    {
        while (true) {
            try {
                Thread.sleep(500);
            }
            catch(Exception e)
            {

            }
            new ZeeslagApplication();
        }
    }
}
