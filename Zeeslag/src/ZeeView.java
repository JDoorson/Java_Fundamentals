import javax.swing.JPanel;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Jamal on 16/03/2017.
 */
public class ZeeView extends JPanel{
    private Zee model;

    public ZeeView(Zee model)
    {
        this.model = model;
        setLayout(new GridLayout(model.getROWS()-2, model.getCOLS()-2, 1,1));
        setBackground(Color.CYAN);
        init();
    }

    private void init()
    {
        final Vakje[][] grid = model.getGrid();
        for (int row = 1; row < model.getROWS() - 1; row++) {
            for (int col = 1; col < model.getCOLS() - 1; col++) {
                if(grid[row][col] instanceof BootVakje)
                    add(new BootVakjeView((BootVakje)grid[row][col]));
                else
                    add(new VakjeView(grid[row][col]));
            }
        }
    }
}
