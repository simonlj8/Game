import java.awt.*;

public class Ball {
	
	private static final int D = 50; //diameter
	private int x = 0;
	private int y = 0;	
	private int moveX = 1;
	private int moveY = 1;
	private Game game;
	private int score = 0;
	Color ballColor = new Color(0, 0, 204);
	
	public Ball(Game game) {
		this.game = game;
	}
	
	 void moveBall() {
		if(x + moveX <= 0)
			moveX = 1;
		if(x + moveX > game.getWidth() -D )
			moveX = -1;
		if(y + moveY < 0)
			moveY = 1;
		if(y + moveY > game.getHeight() -D )
			game.score();
			//game.gameOver();
			//moveY = -1;
		if(collision()) {
			moveY = -2;	
			setScore(1);
		}
		x += moveX;
		y += moveY;
	}
	
	

	public void paint(Graphics2D g) {
		
		//g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(ballColor);
		g.fillOval(x, y, D, D);
		
	}
	
	private Rectangle getBounds() {
		return new Rectangle(x, y, D, D);
	}
	
	private boolean collision() {
		return game.racket.getBounds().intersects(getBounds());
	}
	
	public void setScore(int score) {
		this.score += score;
	}
	
	public int getScore() {
		return score;
	}
}
