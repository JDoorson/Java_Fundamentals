import java.util.*;

public class Main {

	public static void main(String[] args) {
		final int NUM_ROLLS = 200;
		final int MIN = 3; // Equals the amount of dice being rolled
		final int MAX = MIN * 6;
		
		Random gen = new Random();
		int[] aantalKeer = new int[MAX - MIN + 1];

		for (int i = 0; i < NUM_ROLLS; i++) {
			int val = gen.nextInt(MAX - MIN + 1) + MIN;
			aantalKeer[val - MIN]++;
		}

		for (int i = 0; i < aantalKeer.length; i++) {
			int num = aantalKeer[i];
			System.out.print((MIN + i) + ":");
			for (int j = 0; j < num; j++) {
				System.out.print(" X");
			}
			System.out.println();
		}
	}

}
