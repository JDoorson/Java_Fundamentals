/**
 * Created by Jamal on 16/03/2017.
 */
public class BootVakje extends Vakje {
    protected boolean geraakt; //Cell's hit
    protected boolean gezonken; //Cell's boat has sunk

    public BootVakje()
    {
        super();
        geraakt = false;
        gezonken = false;
    }

    public void reveal()
    {
        geraakt = true;
        super.reveal();
    }
}
