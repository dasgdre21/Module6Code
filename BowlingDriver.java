import java.time.LocalDate;
import java.util.ArrayList;
import java.time.Month;

//driver class
public class BowlingDriver {
	public static void main(String[] args) {
		
		//creates Players
		Player ralph = new Player("Ralph");
		Player ben = new Player("Ben");
		Player summer = new Player("Summer");
		Player dream = new Player("Dream");
		Player evan = new Player("Evan");
		
		//adds players to Game one
		ArrayList<Player> players1 = new ArrayList<Player>();
		players1.add(ralph);
		players1.add(ben);
		players1.add(summer);
		players1.add(dream);
		players1.add(evan);
		Game one = new Game(players1);
		one.play();
		
		//adds players to Game two
		ArrayList<Player> players2 = new ArrayList<Player>();
		players2.add(ralph);
		players2.add(summer);
		Game two = new Game(players2);
		two.play();
		
		//adds Players to Game three
		ArrayList<Player> players3 = new ArrayList<Player>();
		players3.add(ralph);
		players3.add(ben);
		Game three = new Game(players3);
		three.play();
		
		//new BowlingTracker created
		BowlingTracker bt = new BowlingTracker();
		
		//games added to BowlingTracker
		//not added in chronologically in order to test program
		bt.addGame(LocalDate.of(2019, Month.NOVEMBER, 17), two);
		bt.addGame(LocalDate.of(2019, Month.NOVEMBER, 16), one); 
		bt.addGame(LocalDate.of(2019, Month.NOVEMBER, 18), three);
		
		//PlayerStats computed and printed
		bt.computeStats();
		System.out.println(bt.printStats());
	
	}	
}
