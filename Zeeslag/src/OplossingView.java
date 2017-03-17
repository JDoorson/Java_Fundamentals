import java.util.Observable;
import java.util.Observer;

/**
 * Created by Jamal on 16/03/2017.
 */
public class OplossingView implements Observer {
    private Zee model;

    public OplossingView() {

    }

    private void print()
    {
        final Vakje[][] grid = model.getGrid();
        for(int row = 1; row < model.getROWS(); row++)
        {
            for(int col = 1; col < model.getCOLS(); col++)
            {
                if(grid[row][col] instanceof Vakje)
                    System.out.print("~ ");
                else if(grid[row][col] instanceof BootVakje)
                    System.out.print("X ");
                else
                    System.out.print(". ");
            }
            System.out.println();
        }
    }

    //Toont alleen de oplossing, dus Observer kan weg?
    public void update(Observable obs, Object obj) {

    }
}
