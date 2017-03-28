import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Jamal on 16/03/2017.
 */
public class Vakje extends Observable implements Serializable, Observer{
    protected boolean bekend; //Cell-type known to the player
    protected boolean marked; //Marked by the player

    public Vakje()
    {
        bekend = false;
        marked = false;
    }

    /**
     * Tagged het vakje als zichtbaar
     */
    public void reveal()
    {
        bekend = true;

        setChanged();
        notifyObservers();
    }

    /**
     * Tagged het vakje als gemarkeerd
     */
    public void mark()
    {
        marked = !marked;

        setChanged();
        notifyObservers();
    }

    /**
     * Ff snel toegevoegd voor tentamenvraag 3 zodat andere vlaggen niet verwijderd worden
     */
    private void autoMark()
    {
        marked = true;

        setChanged();
        notifyObservers();
    }

    public void update(Observable obs, Object obj)
    {
        if(((BootVakje)obs).geraakt)
            autoMark();
    }
}
