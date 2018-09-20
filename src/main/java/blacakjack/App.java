package blacakjack;
import java.util.*;
import java.io.*;
//import java.lang.*;
public class App {
	
	
	
	public static final String[] suite = {"H", "S", "C", "D"};
	public static final String[] rank = {"A", "2", "3", "4", "5", "7", "8", "9", "10", "J", "Q", "K"};
	
	//constructing a new deck
	public List<Card> initDeck(){
		List<Card> newDeck = new ArrayList<Card>();
		for(int i = 0; i<suite.length; i++) {
			for(int j=0; j<rank.length; j++) {
				Card c = new Card(suite[i], rank[j]);
				newDeck.add(c);
			}
		}
		Collections.shuffle(newDeck);
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
	
	//moves a card from deck to hand, returns new total value of the hand
		public int drawCard(List<Card> hand, List<Card> deck, int playertotal) {
			int total;
			Card card = deck.remove(0);
			System.out.println("draws: " + card.toString());
			total = card.getvalue() + playertotal;
			hand.add(card);
			return total;
		}
	public static void main(String[] args) {
		System.out.println("Welcome to BlackJack");
		
		//initial data
		List<Card> playersCards = new ArrayList<Card>(); 
		List<Card> dealersCards = new ArrayList<Card>();
		int playertotal =0;
		int dealertotal =0;
		
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
