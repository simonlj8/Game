import javax.swing.*;
import java.awt.*;
/**
 * @author Simon
 *
 */
public class Grafik extends JPanel {
	
	/**
	 * 
	 * 
	 */
	
	private int WIDTH = 100;
	private int HEIGHT = 100;
	private int d = 50; //diameter
	private int x = 0;
	private int y = 0;
	
	private void moveBall() {
		x += 1;
		y += 1;
	}
	
	private static final long serialVersionUID = 1L;


	public static void main(String[] args) {		
		JFrame frame = new JFrame();
		Grafik grafik = new Grafik();
		
		frame.setSize(900, 900); // x, y
		frame.setLocation(900, 300);
		frame.setDefaultCloseOperation(3);
		frame.add(grafik);
		frame.setTitle("Simons Spel!");
		frame.setResizable(false);
		frame.setVisible(true);
		
		while(true) {
			grafik.moveBall();
			grafik.repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
		

	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.fillOval(x, y, d, d);
		/*g.setColor(Color.black);
		g.fillRect(0, 0, 800, 900);
		g.setColor(Color.red);
		g.drawRect(70, 100, WIDTH, HEIGHT);
		g.setColor(Color.GREEN);
		g.fillRect(160, 200, WIDTH, HEIGHT);
		g.setColor(Color.blue);
		g.drawOval(30, 250, WIDTH, d);
		g.setColor(Color.ORANGE);
		g.fillOval(400, 520, d, d);
	}*/
	}
}
