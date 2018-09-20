package blacakjack;

public class Card {
	//creating a Card object
	
	 String suite;
	 String rank;
	int value;
	//creating card constructor
	public Card(String suite, String rank) {
		this.suite = suite;
		this.rank = rank;
//		this.value = this.getvalue(rank);
	}
//	public int getValue(String rank) {
//		
//	}
	public String toString() {
		return this.suite + this.rank + " ";
	}
}
