package blacakjack;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class appTest extends TestCase{
	
	public void testFileInput() {
		App game = new App();
		List<Card> deck = new ArrayList<Card>();
		deck.add(new Card("S","K"));
		deck.add(new Card("H","A"));
		deck.add(new Card("H","Q"));
		deck.add(new Card("C","A"));
		
		assertEquals(deck.size(), game.readFileInput("testcase.txt").size());
		System.out.println(game.readFileInput("testcase.txt").toString());

	}
	public void testCardValue() {
		App game = new App();
		List<Card> deck = new ArrayList<Card>();
		deck.add(new Card("S","K"));
		deck.add(new Card("H","A"));
		deck.add(new Card("H","Q"));
		deck.add(new Card("H","3"));

		
		assertEquals(10,deck.get(0).getvalue());
		assertEquals(11,deck.get(1).getvalue());
		assertEquals(10,deck.get(2).getvalue());
		assertEquals(3,deck.get(3).getvalue());

	}
}