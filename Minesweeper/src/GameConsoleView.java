import java.util.Observable;
import java.util.Observer;

/**
 * Created by Jamal on 09/03/2017.
 */
public class GameConsoleView implements Observer{
    private MinesweeperModel model;

    public GameConsoleView() {
        model = new MinesweeperModel(10, 10, 10);
        model.addObserver(this);
        print(model);
    }

    public static void main(String[] args) {
        new GameConsoleView();
    }

    public void update(Observable observable, Object obj)
    {

    }

    private void print(MinesweeperModel model)
    {
        Cel[][] grid = model.getGrid();
        for (int row = 1; row < model.getROWS() - 1; row++) {
            for (int col = 1; col < model.getCOLS() - 1; col++) {
                if(grid[row][col].isBomb())
                    System.out.print("B ");
                else
                    System.out.print(grid[row][col].getValue() + " ");
            }
            System.out.println();
        }
    }
}
