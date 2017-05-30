import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * Created by Jamal on 16/03/2017.
 */
public class ZeeslagApplication extends JFrame {
    private Zee model;

    /**
     * Constructor.
     * Maakt het frame, stelt 'm in en voegt alle elementen hier aan toe
     */
    public ZeeslagApplication() {
        try {
            leesModel("zeeslagmodel.dat");
        } catch (Exception ex) {
            model = new Zee(10, 10);
        }

        setBounds(100, 100, 500, 500);
        addWindowListener(new WindowController(model));
        setLayout(new BorderLayout());
        setTitle("Zeeslag");

        new OplossingView(model);
        add(new Statusbalk(model), BorderLayout.NORTH);
        add(new ZeeView(model), BorderLayout.CENTER);
        add(new Knoppenbalk(), BorderLayout.SOUTH);


        setVisible(true);
    }


    /**
     * Leest het model in van bestand
     * @param filename
     * @throws Exception
     */
    private void leesModel(String filename) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
        model = (Zee) ois.readObject();
        ois.close();
    }

    /**
     * Instappunt van de applicatie
     * @param args
     */
    public static void main(String[] args) {
        new ZeeslagApplication();
    }
}
