import java.io.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String name = askName(input);
		printFile(input);
		printFile(input, name);
		System.out.println(new StringBuffer(name).reverse().toString());
		
		input.close();
	}

	public static String askName(Scanner input) {
		System.out.println("What's your name?");
		String name = input.nextLine();

		switch (name) {
		case "Nelleke":
			System.out.println("een speciale begroeting :)");
			break;
		default:
			System.out.println("Hello, " + name + "!");
		}
		
		return name;
	}

	public static void printFile(Scanner input) {
		input = null;
		
		try {
			input = new Scanner(new File("friends.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		while (input.hasNextLine()) {
			System.out.println(input.nextLine());
		}
	}
	
	public static void printFile(Scanner input, String name)
	{
		input = null;
		
		try {
			input = new Scanner(new File(name + ".txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		while (input.hasNextLine()) {
			System.out.println(input.nextLine());
		}
	}
}
