import java.util.Scanner;

public class Player {

	private String name;
	private int balance;

	private Scanner keyboard = new Scanner(System.in);


	// constructor
	public Player(String name, int balance) {
		this.name = name;
		this.balance = balance;
	}

	public Player() {
		this("Kevin", 100);
	}


	// getters
	public String getName() {
		return name;
	}

	public int getBalance() {
		return balance;
	}


	// setters
	public void setName(String name) {
		this.name = name;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}


	// update balance
	public void updateBalance(int delta) {
		balance += delta;
	}

	// to string
	public String toString() {
		String str = 	"\n\nPlayer Name: " + name + "\n" +
						"Balance: $" + balance + "\n\n";
		return str;
	}

	// check balance
	public boolean checkBalance() {
		int delta;
		String userChoice;

		if (getBalance() <= 0) {
			do {
			System.out.print("You don't have enough funds to play. Make a deposit? (y/n)");
			userChoice = keyboard.nextLine().toLowerCase();
			} while (!"n".equals(userChoice) && !"y".equals(userChoice));

			if ("n".equals(userChoice)) {return false;}
			
			do {
			System.out.print("Please make a deposit to play: ");
			delta = keyboard.nextInt();
			keyboard.nextLine();
			} while (delta <= 0);

			updateBalance(delta);
		}

		return true;
	}
}