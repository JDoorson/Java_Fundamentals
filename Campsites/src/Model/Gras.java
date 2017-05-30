package Model;

import java.util.List;

/**
 * Created by Jamal on 30/05/2017.
 */

/**
 * boomBuren: Bomen aan de horizontale en verticale grenzen van dit vakje
 * grasBuren: Model.Gras- en tentvakjes rondom dit vakje
 */
public class Gras extends Vakje {
    protected List<Boom> boomBuren;
    protected List<Gras> grasBuren;

    public Gras()
    {

    }
}
