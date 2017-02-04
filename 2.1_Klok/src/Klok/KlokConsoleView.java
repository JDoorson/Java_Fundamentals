package Klok;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Jamal on 03/02/2017.
 */
public class KlokConsoleView implements Observer {
    private KlokModel model;

    public KlokConsoleView(KlokModel model) {
        this.model = model;
        model.addObserver(this);
    }

    @Override
    public void update(Observable model, Object info) {
        refresh();
    }

    public void refresh() {
        System.out.println(model.getHour() + " uren en " + model.getMin() + " minuten.");
    }
}
