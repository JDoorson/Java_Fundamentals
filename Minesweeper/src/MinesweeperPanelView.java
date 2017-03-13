import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Jamal on 10/03/2017.
 */
public class MinesweeperPanelView extends JPanel implements Observer {
    private MinesweeperModel model;

    public MinesweeperPanelView(MinesweeperModel model) {
        this.model = model;
        setLayout(new GridLayout(model.getROWS() - 2, model.getCOLS() - 2));

        Cel[][] grid = model.getGrid();

        for (int row = 1; row < model.getROWS() - 1; row++) {
            for (int col = 1; col < model.getCOLS() - 1; col++) {
                Cel btn = grid[row][col];
                add(btn);
                btn.addMouseListener(new MinesweeperController(model));
            }
        }
    }

    public void update(Observable observable, Object obj) {

    }
}
