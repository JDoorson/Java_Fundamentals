package life;

public class LifeApplication {
    public LifeApplication() {
        LifeModel model = new LifeModel(20, 30, 10);
        printModel(model);
        runApplication(model, 10);
    }

    public static void main(String[] args) {
        new LifeApplication();
    }

    private void runApplication(LifeModel model, int iterations) {
        for (int i = 0; i < iterations; i++) {
            model.volgendeGeneratie();
            printModel(model);
        }
    }

    private void printModel(LifeModel model) {
        for (int row = 1; row < model.getROWS()-1; row++) {
            for (int col = 1; col < model.getCOLS()-1; col++) {
                if (model.isLevend(row, col))
                    System.out.print("X ");
                else
                    System.out.print(". ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
