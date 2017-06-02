package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jamal on 30/05/2017.
 */

/**
 * boomBuren: Bomen aan de horizontale en verticale grenzen van dit vakje
 * grasBuren: model.Gras- en tentvakjes rondom dit vakje
 */
public class Gras extends Vakje {
    protected List<Boom> boomBuren;
    protected List<Gras> grasBuren;

    public Gras()
    {
        boomBuren = new ArrayList<>();
        grasBuren = new ArrayList<>();
    }

    public void addBoom(Boom b)
    {
        boomBuren.add(b);
    }

    public void addGras(Gras g)
    {
        grasBuren.add(g);
    }
}
