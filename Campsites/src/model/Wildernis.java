package model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Jamal on 30/05/2017.
 */
public class Wildernis {
    private int grootte;
    private Vakje[][] grid;
    private int aantalTenten;

    public Wildernis(int size) {
        //+1 makes checking surroundings easier
        this.grootte = size + 2;
        grid = new Vakje[grootte][grootte];

        initEdges();
    }

    private void initGrid() {
        ArrayList<CelPositie> legeVakjes = new ArrayList<>();
        for (int x = 1; x < getGrootte(); x++) {
            for (int y = 1; y < getGrootte(); y++) {
                if (grid[x][y] == null)
                    legeVakjes.add(new CelPositie(x, y));
            }
        }

        Random rng = new Random();
        int n = rng.nextInt(legeVakjes.size());
        int x = legeVakjes.get(n).getX();
        int y = legeVakjes.get(n).getY();
        Vakje v;

        n = rng.nextInt(4);
        switch (n) {
            case 0:
                v = grid[x][y + 1];
                if (y + 1 != getGrootte() && (v instanceof Gras || v == null)) {
                    v = new Tent();
                    grid[x][y + 1] = new Boom();
                    legeVakjes.remove(n);
                }
                break;
            case 1:
                v = grid[x][y - 1];
                if (y - 1 != 0 && (v instanceof Gras || v == null)) {
                    v = new Tent();
                    grid[x][y - 1] = new Boom();
                    legeVakjes.remove(n);
                }
                break;
            case 2:
                v = grid[x - 1][y];
                if (x - 1 != getGrootte() && (v instanceof Gras || v == null)) {
                    v = new Tent();
                    grid[x - 1][y] = new Boom();
                    legeVakjes.remove(n);
                }
                break;
            case 3:
                v = grid[x + 1][y];
                if (x + 1 != getGrootte() && (v instanceof Gras || v == null)) {
                    v = new Tent();
                    grid[x + 1][y] = new Boom();
                    legeVakjes.remove(n);
                }
                break;
        }
    }

    /**
     * Set the invisible edges of the grid to contain grass
     */
    private void initEdges() {
        for (int x = 0; x < grootte; x += getGrootte()) {
            for (int y = 0; y < grootte; y += getGrootte()) {
                grid[x][y] = new Gras();
            }
        }
    }

    /**
     * Subtracts 1 from grootte because we don't want to use the extra rows and cols
     * assigned in the constructor
     *
     * @return The **visible** size
     */
    public int getGrootte() {
        return grootte - 1;
    }

    public Vakje[][] getGrid() {
        return grid;
    }
}
