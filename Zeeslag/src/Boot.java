import java.util.ArrayList;
import java.util.Observer;
import java.util.Observable;

/**
 * Created by Jamal on 16/03/2017.
 */
public class Boot implements Observer {
    private ArrayList<BootVakje> vakjes;
    private boolean gezonken;

    public Boot(ArrayList<BootVakje> vakjes) {
        this.vakjes = vakjes;
        gezonken = false;

        addModelObservers();
    }

    private void addModelObservers() {
        for (BootVakje v : vakjes)
            v.addObserver(this);
    }

    private boolean bootIsGezonken() {
        for (BootVakje v : vakjes) {
            if (!v.geraakt)
                return false;
        }

        return true;
    }

    private void setGezonken() {
        gezonken = true;
        for (BootVakje v : vakjes) {
            //v.gezonken = true;
            v.setGezonken();
        }
    }

    public void update(Observable obs, Object obj) {
        if (!gezonken && bootIsGezonken())
            setGezonken();
    }
}
