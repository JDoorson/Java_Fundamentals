import java.util.ArrayList;

/**
 * Created by Jamal on 16/03/2017.
 */
public class Boot {
    private ArrayList<BootVakje> vakjes;
    private boolean gezonken;

    public Boot()
    {
        vakjes = new ArrayList<>();
        gezonken = false;
    }

    public void addBootVakje(BootVakje bv)
    {
        vakjes.add(bv);
    }
}
