import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("What's your name?");
		String name = input.nextLine();
		
		switch(name)
		{
		case "Nelleke":
			System.out.println("een speciale begroeting :)");
			break;
		default:
			System.out.println("Hello, " + name + "!");
		}
	}

}
