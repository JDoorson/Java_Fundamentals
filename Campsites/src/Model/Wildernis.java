package Model;

/**
 * Created by Jamal on 30/05/2017.
 */
public class Wildernis {
    private int grootte;
    private Vakje[][] grid;
    private int aantalTenten;

    public Wildernis(int size)
    {
        //+1 makes checking surroundings easier
        this.grootte = size + 2;
        grid = new Vakje[grootte][grootte];
    }

    private void createGrid()
    {
        for(int x = 1; x < getGrootte(); x++)
        {
            for(int y = 1; y < getGrootte(); y++)
            {
                //set grid field
            }
        }
    }

    /**
     * Subtracts 1 from grootte because we don't want to use the extra rows and cols
     * assigned in the constructor
     * @return The **visible** size
     */
    public int getGrootte()
    {
        return grootte - 1;
    }

    public Vakje[][] getGrid()
    {
        return grid;
    }
}
