package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Jamal on 30/05/2017.
 */

/**
 * boomBuren: Bomen aan de horizontale en verticale grenzen van dit vakje
 * grasBuren: model.Gras- en tentvakjes rondom dit vakje
 */
public class Gras extends Vakje implements Observer {
    protected List<Boom> boomBuren;
    protected List<Gras> grasBuren;

    public Gras() {
        boomBuren = new ArrayList<>();
        grasBuren = new ArrayList<>();
        markering = Mark.UNKNOWN;
    }

    public void markAsTent() {
        int n;

        if (markering != Mark.TENT) {
            markering = Mark.TENT;
            n = 1;
        } else {
            markering = Mark.UNKNOWN;
            n = -1;
        }

        setChanged();
        notifyObservers(n);
    }

    public void markAsGras() {
        int n = 0;

        if (markering == Mark.TENT) {
            markering = Mark.GRASS;
            n = -1;
        }
        else if(markering != Mark.GRASS)
            markering = Mark.GRASS;
        else
            markering = Mark.UNKNOWN;

        setChanged();
        notifyObservers(n);
    }

    public void setGras()
    {
        int n = 0;

        if(markering == Mark.TENT)
            n = -1;

        markering = Mark.GRASS;

        setChanged();
        notifyObservers(n);
    }

    public void reset()
    {
        int n = 0;

        if(markering == Mark.TENT)
            n = -1;

        markering = Mark.UNKNOWN;

        setChanged();
        notifyObservers(n);
    }

    public void addBoom(Boom b) {
        boomBuren.add(b);
    }

    public void addGras(Gras g) {
        grasBuren.add(g);
    }

    public Mark getMarkering() {
        return markering;
    }

    public List<Boom> getBoomBuren()
    {
        return boomBuren;
    }

    public void update(Observable obs, Object obj) {
        if(((Gras)obs).getMarkering() == Mark.TENT)
            setGras();
    }
}
