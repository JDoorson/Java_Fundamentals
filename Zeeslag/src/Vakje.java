import java.util.Observable;

/**
 * Created by Jamal on 16/03/2017.
 */
public class Vakje extends Observable {
    protected boolean bekend; //Cell-type known to the player
    protected boolean marked; //Marked by the player

    public Vakje()
    {
        bekend = false;
        marked = false;
    }

    public void reveal()
    {
        bekend = true;

        setChanged();
        notifyObservers();
    }

    public void mark()
    {
        marked = !marked;

        setChanged();
        notifyObservers();
    }
}
