import java.awt.*;

public class Ball {
	
	private int d = 50; //diameter
	private int x = 0;
	private int y = 0;
	
	private int moveX = 1;
	private int moveY = 1;
	private Game game;
	Color ballColor = new Color(0, 0, 204);
	
	public Ball(Game game) {
		this.game = game;
	}
	
	 void moveBall() {
		if(x + moveX <= 0)
			moveX = 1;
		if(x + moveX > game.getWidth() -d )
			moveX = -1;
		if(y + moveY < 0)
			moveY = 1;
		if(y + moveY > game.getHeight() -d )
			moveY = -1;
		x += moveX;
		y += moveY;
	}
	
	

	public void paint(Graphics2D g) {
		
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(ballColor);
		g.fillOval(x, y, d, d);
		
	}
}
