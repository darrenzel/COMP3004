package blacakjack;
import java.util.*;

public class App {
	
	//creating a Card object
	public class Card{
		private String suite;
		private String rank;
		
		//creating card constructor
		public Card(String suite, String rank) {
			this.suite = suite;
			this.rank = rank;
		}
	}
	//sa
	public static final String[] suite = {"H", "S", "C", "D"};
	public static final String[] rank = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	
	//constructing a new deck
	public List<Card> initDeck(String[] suites,String[] rank ){
		List<Card> newDeck = new ArrayList<Card>();
		for(int i = 0; i<suites.length; i++) {
			for(int j=0; j<rank.length; j++) {
				Card c = new Card(rank[j], suites[i]);
				newDeck.add(c);
			}
		}
		return newDeck;
	}
	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);
		System.out.println("Select console(c) input or file (F) input");
		String s = reader.next();
		
		if(s=="F"||s=="f") {
			//use file input to play the game
			System.out.println("please enter the file name");
			String a = reader.next();
			readFileInput(a);
		}else if(s=="C"||s=="c") {
			//use console to start the game
			
		}else {
			System.out.println("invalid input");
			System.exit(0);
		}
	
		
		//List<Cards> deck = new ArrayList<Cards>();
		
	}
	 
}
