/**
 * Created by Jamal on 16/03/2017.
 */
public class ZeeslagApplication {
    public ZeeslagApplication() {
        Zee model = new Zee(10, 10);
        new OplossingView(model);
    }

    public static void main(String[] args) {

        while (true) {
            try {
                Thread.sleep(500);
            }
            catch(Exception e)
            {

            }
            new ZeeslagApplication();
        }
    }
}
