package Klok;

/**
 * Created by Jamal on 03/02/2017.
 */
public class KlokApplicatie {

    public KlokApplicatie()
    {
        KlokModel model = new KlokModel(12, 0);
        KlokConsoleView view = new KlokConsoleView(model);
        while(true)
        {
            model.volgendeMinuut();
            view.refresh();
        }
    }

    public static void main(String[] args)
    {
        new KlokApplicatie();
    }
}
