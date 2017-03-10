import javax.swing.JButton;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Jamal on 10/03/2017.
 */
public class MinesweeperButtonView extends JButton implements Observer {
    private MinesweeperModel model;

    public MinesweeperButtonView(MinesweeperModel model)
    {
        this.model = model;
        model.addObserver(this);

        for(int row = 1; row < model.getROWS() - 1; row++)
        {
            for(int col = 1; col < model.getCOLS() - 1; col++)
            {

            }
        }
    }

    public void update(Observable observable, Object obj)
    {

    }
}
