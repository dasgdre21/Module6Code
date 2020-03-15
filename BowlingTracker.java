import java.util.*;
import java.time.LocalDate;

public class BowlingTracker {	
	
	//fields
	HashMap<LocalDate, Game> games; //key = date of game, value = Game
	HashMap<Player, PlayerStats> stats; //key = Player, value = PlayerStats
	
	//constructor
	public BowlingTracker() {		
		
		this.games = new HashMap<LocalDate, Game>();
		this.stats = new HashMap<Player, PlayerStats>();
	}
	
	//adds to games HashMap
	public void addGame(LocalDate ld, Game g) {
		games.put(ld, g); 
	}
	
	public void computeStats() {
		this.stats.clear(); //clears stats HashMap
		
		//iterates games HashMap
		for (Map.Entry<LocalDate, Game> entry : games.entrySet()) {
			
			LocalDate ld = (LocalDate) entry.getKey(); //key
			Game g = (Game) entry.getValue(); //value
			
			//computes stats for each Player in the Game
			for (Player p : g.getPlayers()) { 
				
				//gets scores by using Player as key for the HashMap in Game
				int [] score = g.getScores().get(p); 
				
				//if Player has already played a game
				if (stats.containsKey(p)) {
					
					PlayerStats ps = (PlayerStats) stats.get(p);
					ps.addGame(score, ld); //adds game to PlayerStats
				}				
				else { //new Player
					stats.put(p, new PlayerStats(score, ld)); //key = Player, value = stats	
				}					
			}			
		}
	}
		
	//returns String with each Player's stats
	public String printStats() {
		
		String s = "Stats:\n";
		
		//iterates stats Hashmap
		for (Map.Entry<Player, PlayerStats> entry : stats.entrySet()) {
			Player p = (Player) entry.getKey(); //key
			PlayerStats ps = (PlayerStats) entry.getValue(); //value
			
			//adds Player's name and stats to String
			s += "\n" + p.toString() + "\n" + ps.toString() + "\n";
		}
		
		return s;
	}
		
}
