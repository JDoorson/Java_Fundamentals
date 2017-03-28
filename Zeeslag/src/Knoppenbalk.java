import javax.swing.*;
import java.awt.*;

/**
 * Created by Jamal on 16/03/2017.
 */
public class Knoppenbalk extends JPanel {
    public Knoppenbalk()
    {
        setLayout(new GridLayout(1,2));
        add(new JButton("Button1"));
        add(new JButton("Button2"));
    }
}
