import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jamal on 11/03/2017.
 */
public class MinesweeperController implements ActionListener {
    private Cel btn;

    public MinesweeperController(Cel btn)
    {
        this.btn = btn;
    }

    public MinesweeperController(){}

    public void actionPerformed(ActionEvent e)
    {
        Cel btn = (Cel)e.getSource();
        btn.setEnabled(false);
        btn.reveal();
    }
}
