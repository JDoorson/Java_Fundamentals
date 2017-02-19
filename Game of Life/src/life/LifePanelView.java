package life;

import javax.swing.JPanel;
import javax.swing.JButton;

/**
 * Created by Jamal on 16/02/2017.
 */
public class LifePanelView extends JPanel {
    public LifePanelView(LifeModel model) {
        for (int y = 1; y < model.getY() - 1; y++) {
            for (int x = 1; x < model.getX() - 1; x++) {
                if(model.isLevend(x,y))
                    add(new JButton("X"));
                else
                    add(new JButton("."));
            }
        }
    }
}
