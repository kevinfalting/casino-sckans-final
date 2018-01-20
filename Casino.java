import java.util.Scanner;

public class Casino {
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Welcome to the casino!");

		// create player
		System.out.print("Please enter your name: ");
		String name = keyboard.nextLine();

		int balance;

		// personalized welcome message
		System.out.println("Welcome to the casino, " + name);

		// get deposit amount
		do {
			System.out.println("How much would you like to deposit into your account? ");
			System.out.print("Min $20, Max $1000: ");
			balance = keyboard.nextInt();
		} while (balance < 20 || balance > 1000);

		//keyboard.nextLine();

		Player player = new Player(name, balance);
		
		String playAgain;

		do {
			System.out.print(	"Please choose 1 for Slot Machine\n" +
								"OR\n" +
								"Please choose 2 for Blackjack\n" +
								"Your selection: ");
			int gameSelection = keyboard.nextInt();

			if (!player.checkBalance()) {break;}

			switch (gameSelection) {
				case 1 :
					SlotMachine.play(player);
					break;
				case 2 :
					Blackjack.play(player);
					break;
				default :
					System.out.println("I don't know what game that is.");
			}

			System.out.println(player);

			do {
				System.out.print("Would you like to play again? (y/n)");
				playAgain = keyboard.next().toLowerCase();
			} while (!"n".equals(playAgain) && !"y".equals(playAgain));

		} while ("y".equals(playAgain));

		System.out.println("Thank you for coming! Bye!");
		System.out.println(player);
	}
}