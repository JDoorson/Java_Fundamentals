package life;

public class LifeApplication {
	private final int ROWS = 20;
	private final int COLS = 30;
	
	public static void main(String[] args)
	{
		LifeModel model = new LifeModel(ROWS, COLS);
		model.print();
	}
}
