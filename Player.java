import java.util.Random;

public class Player {

	// fields
	private String name;
	private final int MAX_SCORE = 100; //100 pin bowling

	// constructor
	public Player(String name) {
		this.name = name;
	}

	// adds randomly generated scores to each round
	public int[] playGame(int n) {

		int[] turns = new int[n];
		Random r = new Random();

		for (int i = 0; i < turns.length; i++) {
			turns[i] = r.nextInt(MAX_SCORE + 1); //generates random score from 0-100
		}

		return turns;
	}

	public String toString() {
		return "Player: " + this.name;
	}

}
