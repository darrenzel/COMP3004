package blacakjack;
import java.util.*;
import java.io.*;
//import java.lang.*;
public class App {
	
	
	
	public static final String[] suite = {"H", "S", "C", "D"};
	public static final String[] rank = {"A", "2", "3", "4", "5", "7", "8", "9", "10", "J", "Q", "K"};
	
	//constructing a new deck
	public static List<Card> initDeck(){
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
	public static int drawCard(List<Card> hand, List<Card> deck) {
		Card card = deck.remove(0);
//		System.out.println("draws: " + card.toString());
//		playertotal += card.getvalue();
		hand.add(card);
//		System.out.println("CARD VALUE IS : "+playertotal);
		return card.getvalue();
	}
	
	//checks if someone won the game
	public static boolean blackjack(List<Card> hand) {
		for(int i=0; i<hand.size(); i++) {
			if(hand.get(i).rank.equals("A")) {
				for(int j=0; j<hand.size(); j++) {
					if(hand.get(j).getvalue()==10 && !hand.get(j).rank.equals("10")) {
						System.out.println("BlackJack! ");
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static boolean winCheck(int dealer, int player) {
		if(dealer==21) {
			System.out.println("dealer wins");
			return true;
		}else if(player==21) {
			System.out.println("you win!");
			return true;
		}else if(player>21) {
			System.out.println("you bust");
			return true;
		}else if(dealer >21) {
			System.out.println("dealer busts, you win!");
			return true;
		}
//		else if(player<dealer) {
//			System.out.println("dealer wins with more valued hand of cards");
//			return true;
//		}else if(player>dealer){
//			System.out.println("you win!");
//			return true;
//		}
		else {
			return false;
		}
	}
		
	public static void main(String[] args) {
		System.out.println("Welcome to BlackJack");
		
		//initial data
		List<Card> playerCards = new ArrayList<Card>(); 
		List<Card> dealerCards = new ArrayList<Card>();
		int playertotal =0;
		int dealertotal =0;
		boolean playing = true;
		
		Scanner reader = new Scanner(System.in);
		System.out.println("Select console(c) input or file (F) input");
		String s = reader.nextLine();
		
		if(s.equals("F")||s.equals("f")) {
			//use file input to play the game
//			List<Card> filedeck = new ArrayList<Card>();
			System.out.println("please enter the file name");
			String a = reader.next();
			List<Card> fileDeck = new ArrayList<Card>();
			fileDeck = readFileInput(a);
			playertotal+=drawCard(playerCards, fileDeck);
			System.out.println("player received: "+ playerCards.get(playerCards.size()-1).toString());
			playertotal+=drawCard(playerCards, fileDeck);
			System.out.println("player received: "+playerCards.get(playerCards.size()-1).toString());
			
			dealertotal+=drawCard(dealerCards, fileDeck);
			System.out.println("dealer received: "+ dealerCards.get(dealerCards.size()-1).toString());
			dealertotal+=drawCard(dealerCards, fileDeck);
			System.out.println("dealer received a hidden Card ");
			if(blackjack(dealerCards)==true) {
				System.out.println("dealer gets blackjack, game over");
				System.exit(0);
			}else if(blackjack(playerCards)==true) {
				System.out.println("player wins!");
				System.exit(0);
			}
			while(playing && reader.hasNext()) {
				//player's turn
				boolean soft=false;
				System.out.println("dealer's cards are: ");
				for(int i=0; i<dealerCards.size(); i++) {
					System.out.println(dealerCards.get(i).toString());
					if(dealerCards.get(i).rank=="A" && dealertotal==17) {
						soft=true;
					}
				}
				if(dealertotal<=16 || soft==true) {
					dealertotal+=drawCard(dealerCards, fileDeck);
					System.out.println("dealer hits and received: "+ dealerCards.get(dealerCards.size()).toString());
					if(blackjack(dealerCards)==true) {
						System.out.println("dealer gets blackjack, game over");
						System.exit(0);
					}
					if(dealertotal>21) {
						System.out.println("dealer busts, you win!");
						System.exit(0);
					}
				}else {
					System.out.println("dealer stays");
				}
				//dealer's turn
				boolean soft2=false;
				System.out.println("dealer's cards are: ");
				for(int i=0; i<dealerCards.size(); i++) {
					System.out.println(dealerCards.get(i).toString());
					if(dealerCards.get(i).rank=="A" && dealertotal==17) {
						soft2=true;
					}
				}
				if(dealertotal<=16 || soft==true) {
					dealertotal+=drawCard(dealerCards, fileDeck);
					System.out.println("dealer hits and received: "+ dealerCards.get(dealerCards.size()).toString());
					if(blackjack(dealerCards)==true) {
						System.out.println("dealer gets blackjack, game over");
						System.exit(0);
					}
					if(dealertotal>21) {
						System.out.println("dealer busts, you win!");
						System.exit(0);
					}
				}else {
					System.out.println("dealer stays");
				}
				
			}
			
			
			
		}else if(s.equals("C")||s.equals("c")) {
			//use console to start the game
			List<Card> deck = initDeck();
			
			playertotal+=drawCard(playerCards, deck);
			System.out.println("you received: "+ playerCards.get(playerCards.size()-1).toString());
			playertotal+=drawCard(playerCards, deck);
			System.out.println("you received: "+playerCards.get(playerCards.size()-1).toString());
			
			dealertotal+=drawCard(dealerCards, deck);
			System.out.println("dealer received: "+ dealerCards.get(dealerCards.size()-1).toString());
			dealertotal+=drawCard(dealerCards, deck);
			System.out.println("dealer received a hidden Card ");
			if(blackjack(dealerCards)==true) {
				System.out.println("dealer gets blackjack, game over");
				System.exit(0);
			}else if(blackjack(playerCards)==true) {
				System.out.println("you win!");
				System.exit(0);
			}
			
			while(playing) {
				System.out.println("would you like to hit (h) or stand (s)");
				String a = reader.next();
				if(a.equals("h") ||a.equals("H")) {
					playertotal+=drawCard(playerCards, deck);
					System.out.println("you received: "+playerCards.get(playerCards.size()-1).toString());
//					System.out.println("TOTAL VALUE IS: "+playertotal);
					if(playertotal>21) {
						System.out.println("you bust, dealer wins");
						System.exit(0);
					}
				}else if(a.equals("S")||a.equals("s")) {
					System.out.println("you are staying");
				}else if(s.equals("D")||s.equals("d")) {
					//plays split
				}
				//dealer's turn
				boolean soft=false;
				System.out.println("dealer's cards are: ");
				for(int i=0; i<dealerCards.size(); i++) {
					System.out.println(dealerCards.get(i).toString());
					if(dealerCards.get(i).rank=="A" && dealertotal==17) {
						soft=true;
					}
				}
				if(dealertotal<=16 || soft==true) {
					dealertotal+=drawCard(dealerCards, deck);
					System.out.println("dealer hits and received: "+ dealerCards.get(dealerCards.size()).toString());
					if(blackjack(dealerCards)==true) {
						System.out.println("dealer gets blackjack, game over");
						System.exit(0);
					}
					if(dealertotal>21) {
						System.out.println("dealer busts, you win!");
						System.exit(0);
					}
				}else {
					System.out.println("dealer stays");
				}
				
			}
		}
		else {
			System.out.println("invalid input");
			System.exit(0);
		}
	
		
		//List<Cards> deck = new ArrayList<Cards>();
		reader.close();
	}
	 
}
