import java.util.ArrayList;
import java.util.HashMap;

public class Game {
	
	//fields
	private ArrayList<Player> players;
	private HashMap<Player, int[]> scores; //key = Player, value = array of scores
	private final int MAX_TURNS = 10; //each player plays 10 times
	
	//constructor
	public Game(ArrayList<Player> players) {
		this.players = players;
		this.scores = new HashMap<Player, int[]>();
	}
	
	//puts Players and randomly generated scores into HashMap
	public void play() {
		for (Player p : players) {
			scores.put(p, p.playGame(MAX_TURNS)); //key = Player, value = int[] scores		
		}		
	}
	
	//accessors
	public ArrayList<Player> getPlayers() {
		return this.players;
	}
	
	public HashMap<Player, int[]> getScores() {
		return scores;
	}

}
