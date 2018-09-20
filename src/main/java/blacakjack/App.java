package blacakjack;
import java.util.*;
import java.io.*;
//import java.lang.*;
public class App {
	
	
	
	public static final String[] suite = {"H", "S", "C", "D"};
	public static final String[] rank = {"A", "2", "3", "4", "5", "7", "8", "9", "10", "J", "Q", "K"};
	
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
	//read from a file, assuming all data is valid cards
		public static List<Card> readFileInput(String file){
			Scanner reader = null;
			List<Card> fileDeck = new ArrayList<Card>();
		    try {
		        reader = new Scanner(new File(file));
		    } catch (FileNotFoundException error) {
		        error.printStackTrace();  
		    }
		    while(reader.hasNext()) {
		    	String cardString = reader.next();
		    	Card nextCard = new Card(Character.toString(cardString.toCharArray()[0]),Character.toString(cardString.toCharArray()[1]));
		    	fileDeck.add(nextCard);
		    }
		    return fileDeck;
		}
	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);
		System.out.println("Select console(c) input or file (F) input");
		String s = reader.next();
		
		if(s=="F"||s=="f") {
			//use file input to play the game
			List<Card> deck = new ArrayList<Card>();
			System.out.println("please enter the file name");
			String a = reader.next();
			deck = readFileInput(a);
		}else if(s=="C"||s=="c") {
			//use console to start the game
			
		}else {
			System.out.println("invalid input");
			System.exit(0);
		}
	
		
		//List<Cards> deck = new ArrayList<Cards>();
		reader.close();
	}
	 
}
