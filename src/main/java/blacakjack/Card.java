package blacakjack;

import java.util.*;

public class Card {
	//creating a Card object
	
	 String suite;
	 String rank;
	int value;
	//creating card constructor
	public Card(String suite, String rank) {
		this.suite = suite;
		this.rank = rank;
		this.value = this.getvalue();
	}
	public int getvalue() {
		if(this.rank.equals("J")||this.rank.equals("Q")||this.rank.equals("K")){
			return 10;
		}else if(this.rank.equals("A")) {
			return 11;
		}else {
			return Integer.parseInt(this.rank);
		}
		
	}
	
	
	public String toString() {
		return this.suite + this.rank + " ";
	}
}
