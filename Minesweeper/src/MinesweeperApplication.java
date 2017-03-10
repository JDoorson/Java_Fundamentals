import javax.swing.*;

/**
 * Created by Jamal on 10/03/2017.
 */
public class MinesweeperApplication extends JFrame {
    private MinesweeperModel model;

    public MinesweeperApplication()
    {
        model = new MinesweeperModel(10, 10, 15);

    }
}
