package blacakjack;

import junit.framework.TestCase;

public class appTest extends TestCase{
	
	public void testFileInput() {
		App game = new App();
		assertSame("SK	HA	HQ	CA", game.readFile("testcase.txt");)
	}
	
}