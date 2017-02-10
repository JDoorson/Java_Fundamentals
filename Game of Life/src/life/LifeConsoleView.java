package life;

/**
 * Created by Jamal on 10/02/2017.
 */
public class LifeConsoleView {
    private LifeModel model;

    public LifeConsoleView(LifeModel model)
    {
        this.model = model;
    }

    private void showCel(int x, int y)
    {
        if(model.isLevend(x, y))
            System.out.print("X ");
        else
            System.out.print(". ");
    }

    public void refresh()
    {
        for (int y = 1; y < model.getY()-1; y++) {
            for (int x = 1; x< model.getX()-1; x++) {
                showCel(x, y);
            }
            System.out.println();
        }
        System.out.println();
    }
}
