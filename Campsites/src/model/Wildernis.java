package model;

import java.lang.reflect.Array;
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
        initGrid();
    }

    public void voegBurenToe(Gras v, int x, int y) {
        for (int i = x - 1; x <= x + 1; i++) {
            for (int j = y - 1; y <= y + 1; j++) {
                if (i == 0 && j == 0)
                    continue;

                if (grid[i][j] instanceof Gras)
                    v.addGras((Gras) grid[i][j]);
                else if (grid[i][j] instanceof Boom)
                    v.addBoom((Boom) grid[i][j]);
            }
        }
    }

    private boolean isInBounds(int xPos, int yPos) {
        return !(xPos == 0 || xPos == getGrootte() || yPos == 0 || yPos == getGrootte());
    }

    /**
     * Collect all empty cels on the visible grid
     * Randomly select one of the cels out of the empty ones
     * Randomly select one of the four adjacent cels and check if it's in bounds and empty or grass
     * Call {@link #assignCels(CelPositie, CelPositie)}
     * <p>
     * Repeat until no more empty cels are present on the grid
     */
    private void initGrid() {
        ArrayList<CelPositie> legeVakjes = new ArrayList<>();

        do {
            legeVakjes.clear();

            for (int x = 1; x < getGrootte(); x++) {
                for (int y = 1; y < getGrootte(); y++) {
                    if (grid[x][y] == null) {
                        legeVakjes.add(new CelPositie(x, y));
                    }
                }
            }

            if (legeVakjes.size() <= 0) break;

            Random rng = new Random();
            int index = rng.nextInt(legeVakjes.size());
            int x = legeVakjes.get(index).getX();
            int y = legeVakjes.get(index).getY();
            CelPositie cPos;

            int n = rng.nextInt(4);
            switch (n) {
                case 0:
                    cPos = new CelPositie(x, y + 1);
                    if (cPos.getY() != getGrootte()
                            && (grid[cPos.getX()][cPos.getY()] instanceof Gras
                            || grid[cPos.getX()][cPos.getY()] == null)) {
                        assignCels(legeVakjes.get(index), cPos);
                        legeVakjes.remove(index);
                    }
                    break;
                case 1:
                    cPos = new CelPositie(x, y - 1);
                    if (cPos.getY() != 0
                            && (grid[cPos.getX()][cPos.getY()] instanceof Gras
                            || grid[cPos.getX()][cPos.getY()] == null)) {
                        assignCels(legeVakjes.get(index), cPos);
                        legeVakjes.remove(index);
                    }
                    break;
                case 2:
                    cPos = new CelPositie(x - 1, y);
                    if (cPos.getX() != 0
                            && (grid[cPos.getX()][cPos.getY()] instanceof Gras
                            || grid[cPos.getX()][cPos.getY()] == null)) {
                        assignCels(legeVakjes.get(index), cPos);
                        legeVakjes.remove(index);
                    }
                    break;
                case 3:
                    cPos = new CelPositie(x + 1, y);
                    if (cPos.getX() != getGrootte()
                            && (grid[cPos.getX()][cPos.getY()] instanceof Gras
                            || grid[cPos.getX()][cPos.getY()] == null)) {
                        assignCels(legeVakjes.get(index), cPos);
                        legeVakjes.remove(index);
                    }
                    break;
                default:
                    break;
            }
        } while (!legeVakjes.isEmpty());

        for (int x = 1; x < getGrootte(); x++) {
            for (int y = 1; y < getGrootte(); y++) {
                if (grid[x][y] instanceof Gras)
                    voegBurenToe((Gras) grid[x][y], x, y);
            }
        }
    }

    /**
     * Assign a tent and a tree to two adjacent cels.
     *
     * @param tentPos Position of the cel where a tent will be placed
     * @param boomPos Position of the cel where a tree will be placed
     */
    private void assignCels(CelPositie tentPos, CelPositie boomPos) {
        grid[tentPos.getX()][tentPos.getY()] = new Tent();
        grid[boomPos.getX()][boomPos.getY()] = new Boom();

        for (int x = tentPos.getX() - 1; x <= tentPos.getX() + 1; x++) {
            for (int y = tentPos.getY() - 1; y <= tentPos.getY() + 1; y++) {
                if (grid[x][y] == null)
                    grid[x][y] = new Gras();
            }
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
