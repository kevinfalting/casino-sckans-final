import java.util.Scanner;

public class Blackjack {

	public static void play(Player player) {

		String userChoice;
		int bet, userScore = 0, computerScore = 0;

		Scanner keyboard = new Scanner(System.in);

		// make a bet
		do {
			System.out.println(player);
			System.out.print("Please enter the amount you're betting: ");
			bet = keyboard.nextInt();
		} while (bet <= 0 || bet > player.getBalance());


		do {

			System.out.println("Your score is: " + userScore);
			do {
				System.out.print("Roll? (y/n) : ");
				userChoice = keyboard.next();
			} while (!"y".equals(userChoice) && !"n".equals(userChoice));

			if ("n".equals(userChoice)) { break;}

			// computer rolls
			computerScore += Dice.roll();
			computerScore += Dice.roll();

			// user rolls
			userScore += Dice.roll();
			userScore += Dice.roll();

			if (userScore >= 21 || computerScore >= 21) {break;}

		} while ("y".equals(userChoice));

		// figure out who won
		if (bet == 0) {
			System.out.println(player);
		} else if (userScore > 21) {
			// player lost
			player.updateBalance(bet * -1);
			System.out.println("House Score: " + computerScore +
								"\nPlayer Score: " + userScore);
			System.out.println("I'm sorry, you lost.");
		} else if (userScore > computerScore || userScore == 21 || computerScore > 21) {
			// player won
			player.updateBalance(bet * 2);
			System.out.println("House Score: " + computerScore +
								"\nPlayer Score: " + userScore);
			System.out.println("You won!");
		} else {
			// player lost
			player.updateBalance(bet * -1);
			System.out.println("House Score: " + computerScore +
								"\nPlayer Score: " + userScore);
			System.out.println("I'm sorry, you lost.");
		}

		//System.out.println(player);

	}
}