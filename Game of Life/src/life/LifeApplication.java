package life;

public class LifeApplication {
    public LifeApplication() {
        LifeModel model = new LifeModel(20, 30, 10);
        printModel(model);
        runApplication(model, 20);
    }

    public static void main(String[] args) {
        new LifeApplication();
    }

    private void runApplication(LifeModel model, int iterations)
    {
        for(int i = 0; i < iterations; i++)
        {
            model.volgendeGeneratie();
            printModel(model);
        }
    }

    private void printModel(LifeModel model) {
        //System.out.print("0 1 2 3 4 5 6 7 8 9");
        //System.out.print(" 0 1 2 3 4 5 6 7 8 9");
        //System.out.println(" 0 1 2 3 4 5 6 7 8 9");
        for (int row = 0; row < model.getROWS(); row++) {
            for (int col = 0; col < model.getCOLS(); col++) {
                if (model.isLevend(row, col))
                    System.out.print("X ");
                else
                    System.out.print(". ");
            }
            //System.out.println(row);
        }
        System.out.println();
    }
}
