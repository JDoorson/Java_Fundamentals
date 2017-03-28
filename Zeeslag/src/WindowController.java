import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by Jamal on 28/03/2017.
 */
public class WindowController extends WindowAdapter {
    private Zee model;

    public WindowController(Zee model) {
        this.model = model;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("zeeslagmodel.dat"));

            oos.writeObject(model);
            oos.close();
        } catch (IOException ex) {
            System.out.println("Something went wrong: " + ex.getStackTrace());
        }
        System.exit(0);
    }
}
