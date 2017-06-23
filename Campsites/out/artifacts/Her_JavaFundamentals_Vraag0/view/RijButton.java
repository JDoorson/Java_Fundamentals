package view;

import model.Boom;
import model.Gras;
import model.Mark;
import model.Tent;
import model.Vakje;
import model.Wildernis;

/**
 * Created by Jamal on 30/05/2017.
 */
public class RijButton extends LijnButton {
    public RijButton(int lijn, Wildernis model) {
        super(lijn, model);
    }

    protected int getAantal() {
        Vakje[][] grid = model.getGrid();
        int n = 0;
        for (int i = 1; i < model.getGrootte(); i++) {
            if (grid[lijn][i] instanceof Tent)
                n++;
            grid[lijn][i].addObserver(this);
        }
        return n;
    }

    protected void checkLine() {

        if (placedTents == maxTents)
            fillWithGrass();
        else if (placedTents > maxTents || (isComplete() && placedTents < maxTents))
            resetLine();
    }

    protected boolean isComplete() {
        Vakje[][] grid = model.getGrid();
        for (int i = 1; i < model.getGrootte(); i++) {
            if (grid[lijn][i] instanceof Gras && ((Gras) grid[lijn][i]).getMarkering() == Mark.UNKNOWN)
                return false;
        }
        return true;
    }

    protected void fillWithGrass() {
        Vakje[][] grid = model.getGrid();
        for (int i = 1; i < model.getGrootte(); i++) {
            if (grid[lijn][i] instanceof Gras && ((Gras) grid[lijn][i]).getMarkering() == Mark.UNKNOWN)
                ((Gras) grid[lijn][i]).setGras();
        }
    }


    protected void resetLine() {
        Vakje[][] grid = model.getGrid();
        for (int i = 1; i < model.getGrootte(); i++) {
            if (grid[lijn][i] instanceof Gras)
                ((Gras) grid[lijn][i]).reset();
        }
    }
}
