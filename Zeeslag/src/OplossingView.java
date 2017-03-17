import java.util.Observable;
import java.util.Observer;

/**
 * Created by Jamal on 16/03/2017.
 */
public class OplossingView {
    private Zee model;

    public OplossingView(Zee model) {
        this.model = model;
        print();
    }

    private void print() {
        final Vakje[][] grid = model.getGrid();
        for (int row = 1; row < model.getROWS() - 1; row++) {
            for (int col = 1; col < model.getCOLS() - 1; col++) {
                if (grid[row][col] instanceof BootVakje)
                    System.out.print("X ");
                else if (grid[row][col] != null)
                    System.out.print("~ ");
                else
                    System.out.print(". ");
            }
            System.out.println();
        }
    }
}
