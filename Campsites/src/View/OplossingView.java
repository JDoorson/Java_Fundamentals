package View;

import Model.Boom;
import Model.Gras;
import Model.Tent;
import Model.Vakje;
import Model.Wildernis;

/**
 * Created by Jamal on 30/05/2017.
 */
public class OplossingView {
    private Wildernis model;

    public OplossingView(Wildernis model)
    {
        this.model = model;
        drawSolution();
    }

    private void drawSolution()
    {
        Vakje[][] grid = model.getGrid();

        for(int x = 1; x < model.getGrootte(); x++)
        {
            for(int y = 1; y < model.getGrootte(); y++)
            {
                if(grid[x][y] == null)
                    System.out.print(". ");
                else if(grid[x][y] instanceof Tent)
                    System.out.print("T ");
                else if(grid[x][y] instanceof Gras)
                    System.out.print("G ");
                else if(grid[x][y] instanceof Boom)
                    System.out.print("B ");
            }

            System.out.println();
        }
    }
}
