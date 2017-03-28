import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observer;
import java.util.Observable;

/**
 * Created by Jamal on 16/03/2017.
 */
public class Boot implements Observer, Serializable{
    private ArrayList<BootVakje> vakjes;
    private boolean gezonken;

    public Boot(ArrayList<BootVakje> vakjes) {
        this.vakjes = vakjes;
        gezonken = false;
    }

    /**
     * Voegt de Boot toe als Observer aan al zijn delen (BootVakjes)
     */
    public void addModelObservers() {
        for (BootVakje v : vakjes)
            v.addObserver(this);
    }

    /**
     * Controlleerd of alle delen van de boot geraakt zijn
     * @return
     */
    private boolean bootIsGezonken() {
        for (BootVakje v : vakjes) {
            if (!v.geraakt)
                return false;
        }

        return true;
    }

    /**
     * Tagged de boot en al zijn delen als gezonken
     */
    private void setGezonken() {
        gezonken = true;
        for (BootVakje v : vakjes) {
            //v.gezonken = true;
            v.setGezonken();
        }
    }

    /**
     * Wordt geroepen als er iets gebeurt met een van zn Observables.
     * Controlleerd of de gehele boot nu gezonken is
     * @param obs
     * @param obj
     */
    public void update(Observable obs, Object obj) {
        if (!gezonken && bootIsGezonken())
            setGezonken();
    }

    /**
     * Getter
     * @return
     */
    public boolean isGezonken()
    {
        return gezonken;
    }
}
