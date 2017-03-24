import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Jamal on 16/03/2017.
 */
public class Boot {
    private ArrayList<BootVakje> vakjes;
    private boolean gezonken;

    public Boot(ArrayList<BootVakje> vakjes)
    {
        this.vakjes = vakjes;
        gezonken = false;
    }
}
