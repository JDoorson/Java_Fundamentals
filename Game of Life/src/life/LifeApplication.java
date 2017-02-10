package life;

public class LifeApplication {

    public static void main(String[] args) {
        LifeModel model = new LifeModel(30, 20, 10);
        LifeConsoleView view = new LifeConsoleView(model);

        while(true)
        {
            model.volgendeGeneratie();
            view.refresh();

            try{Thread.sleep(2000);}
            catch(InterruptedException ie){}
        }
    }
/*
    private void runApplication(LifeModel model, int iterations) {
        for (int i = 0; i < iterations; i++) {
            model.volgendeGeneratie();
            printModel(model);
        }
    }

    private void printModel(LifeModel model) {
        for (int y = 1; y < model.getY()-1; y++) {
            for (int x = 1; x< model.getX()-1; x++) {
                if (model.isLevend(x, y))
                    System.out.print("X ");
                else
                    System.out.print(". ");
            }
            System.out.println();
        }
        System.out.println();
    }
*/
}
