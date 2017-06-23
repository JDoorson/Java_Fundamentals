package view;

import model.Gras;
import model.Mark;
import model.Tent;
import model.Vakje;
import model.Wildernis;

/**
 * Created by Jamal on 30/05/2017.
 */
public class KolomButton extends LijnButton {
    public KolomButton(int lijn, Wildernis model) {
        super(lijn, model);
    }

    protected int getAantal() {
        Vakje[][] grid = model.getGrid();
        int n = 0;
        for (int i = 1; i < model.getGrootte(); i++) {
            if (grid[i][lijn] instanceof Tent)
                n++;
            grid[i][lijn].addObserver(this);
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
            if (grid[i][lijn] instanceof Gras && ((Gras) grid[i][lijn]).getMarkering() == Mark.UNKNOWN)
                return false;
        }
        return true;
    }

    protected void fillWithGrass() {
        Vakje[][] grid = model.getGrid();
        for (int i = 1; i < model.getGrootte(); i++) {
            if (grid[i][lijn] instanceof Gras && ((Gras) grid[i][lijn]).getMarkering() == Mark.UNKNOWN)
                ((Gras) grid[i][lijn]).setGras();
        }
    }


    protected void resetLine() {
        Vakje[][] grid = model.getGrid();
        for (int i = 1; i < model.getGrootte(); i++) {
            if (grid[i][lijn] instanceof Gras)
                ((Gras) grid[i][lijn]).reset();
        }
    }
}
