import java.time.LocalDate;

public class PlayerStats {
	
	//fields
	private int numGames;
	private int totalScore;
	private int lastScore;
	private LocalDate lastDate;
	
	//constructor
	public PlayerStats(int[] scores, LocalDate date) {
		
		this.numGames = 0;
		this.totalScore = 0;
		this.lastScore = 0;
		this.lastDate = null;
		this.addGame(scores, date);
		
	}
	
	//returns Player's stats
	public String toString() {
		String s1 = "Number of games: " + this.numGames;
		String s2 = "Average Score of all games: " + (this.totalScore / this.numGames);
		String s3 = "Score of last game: " + this.lastScore;
		String s4 = "Date of last game: " + this.lastDate; //LocalDate toString() invoked
		
		return s1 + "\n" + s2 + "\n" + s3 + "\n" + s4;
	}
	
	public void addGame(int[] scores, LocalDate date) {
		
		this.numGames++;
		int thisScore = 0; //score for this game
		
		//computes total for this game
		for (int i : scores) {
			thisScore += i;
		}
		
		//adds this game's total to total for all games
		this.totalScore += thisScore;
		
		//if this is most recent game
		if (lastDate == null || date.compareTo(lastDate) > 0) { 
			this.lastDate = date;
			this.lastScore = thisScore;
		}
	}
}
