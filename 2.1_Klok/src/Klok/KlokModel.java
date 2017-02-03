package Klok;

/**
 * Created by Jamal on 03/02/2017.
 */
public class KlokModel {
    private int hour, min;

    public KlokModel(int hour, int min) {
        this.hour = hour;
        this.min = min;
    }

    public void volgendeMinuut() {
        if (min < 59) min++;
        else {
            volgendUur();
            min = 0;
        }
    }

    private void volgendUur() {
        if (hour < 23) hour++;
        else hour = 0;
    }

    public int getHour() {
        return hour;
    }

    public int getMin() {
        return min;
    }
}
