import java.util.Random;

public class Dice {

	private final static int DICE_SIDES = 6;

	private static Random random = new Random();

	public static int roll() {
		return random.nextInt(DICE_SIDES) + 1;
	}
}