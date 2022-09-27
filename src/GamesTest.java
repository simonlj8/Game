import static org.junit.jupiter.api.Assertions.*;

import java.awt.AWTException;
import java.awt.Frame;

import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author simon
 *
 */
class GamesTest {

	/**
	 * Test method for {@link Game#Game()}.
	 * @throws AWTException 
	 */
	@Test
	void testGame()  {

		
	}

	/**
	 * Test method for {@link Game#main(java.lang.String[])}.
	 */
	@Test
	void testMain() {
		
		JFrame frame = new JFrame();
		frame.setSize(700, 800);
		assertEquals(frame,  frame);
	}

	/**
	 * Test method for {@link Game#paint(java.awt.Graphics)}.
	 */
	@Test
	void testPaintGraphics() {
		
		
	}

	/**
	 * Test method for {@link Game#score()}.
	 */
	@Test
	void testScore() {
		
	}

	/**
	 * Test method for {@link Game#gameOver()}.
	 */
	@Test
	void testGameOver() {
		
	}

	/**
	 * Test method for {@link Game#welcomMessage()}.
	 */
	@Test
	void testWelcomMessage() {
		
	}

}
