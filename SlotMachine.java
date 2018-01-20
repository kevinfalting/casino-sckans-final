import java.util.Random;
import java.util.Scanner;

public class SlotMachine {

	private static final String[] SLOT_CHOICES = {"Cherries", "Oranges", "Plums", "Bells", "Melons", "Bars"};
	
	private static Random random = new Random();
	private static Scanner keyboard = new Scanner(System.in);

	// playing the game
	public static void play(Player player) {
		
		String[] results = new String[3];
		int bet;

		// make a bet
		do {
			System.out.println(player);
			System.out.print("Please enter the amount you're betting: ");
			bet = keyboard.nextInt();
		} while (bet <= 0 || bet > player.getBalance());
		

		// pulling the lever to see what we get
		for (int i = 0; i < 3; i++) {
			results[i] = SLOT_CHOICES[random.nextInt(SLOT_CHOICES.length)];
		}

		// display the results
		System.out.println("\nHere are the results of the play:\n\n" +
							results[0] + " | " + results[1] + " | " + results[2] + "\n");

		// check the results
		if (results[0].equals(results[1]) && results[0].equals(results[2])) {
			// all 3 match
			player.updateBalance(bet * 2);
			System.out.println("You've won 3 times your bet!");
		} else if (results[0].equals(results[1]) || results[0].equals(results[2]) || results[1].equals(results[2])) {
			// two symbols match
			player.updateBalance(bet);
			System.out.println("You've won 2 times your bet!");
		} else {
			// no symbols match
			player.updateBalance(bet * -1);
			System.out.println("You have won $0.");
		}
	}
}