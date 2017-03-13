import javax.swing.*;

/**
 * Created by Jamal on 10/03/2017.
 */
public class MinesweeperApplication extends JFrame {
    private MinesweeperModel model;

    public MinesweeperApplication()
    {
        model = new MinesweeperModel(20, 20, 10);
        initFrame();
    }

    public static void main(String[] args)
    {
        new MinesweeperApplication();
    }

    private void initFrame()
    {
        setBounds(100, 100, 1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Minesweeper");
        add(new MinesweeperPanelView(model));
        setVisible(true);
    }
}
