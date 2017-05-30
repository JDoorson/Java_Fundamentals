package Controller;

import Model.Wildernis;
import View.OplossingView;

/**
 * Created by Jamal on 30/05/2017.
 */
public class CampsitesApplication {
    public CampsitesApplication()
    {
        Wildernis model = new Wildernis(10);
        new OplossingView(model);
    }

    public static void main(String[] args)
    {
        new CampsitesApplication();
    }
}
