import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.*;

public class Cat {
	// drawing constants are private - noone needs to know what we're doing
	// pick a head dimension
	private static final int HEAD_DIMENSION = 100;
	// eyes will be about 1/4 from top of head and 1/4 from left
	private static final int EYE_Y = HEAD_DIMENSION/4;
	private static final int EYE_X = HEAD_DIMENSION/4;
	private static final int EYE_SEPARATION = HEAD_DIMENSION/3;
	// pick eye dimensions
	private static final int EYE_HEIGHT = 20;
	private static final int EYE_WIDTH = 10;
	// pick mouth height, width is based on head dimension
	private static final int MOUTH_HEIGHT = 10;
	private static final int MOUTH_WIDTH = HEAD_DIMENSION/4;
	// mouth starts about 40% from left edge of head
	private static final int MOUTH_X = HEAD_DIMENSION/5 * (5/2);
	private static final int MOUTH_Y = HEAD_DIMENSION/5 * (7/2);
	//Nose dimensions
	private static final int NOSE_X = 45;
	private static final int NOSE_Y = 55;
	//ear dimensions
	private static final int EAR_X = 4;
	private static final int EAR_Y = 25;
	// draw will render the Cat on the Graphics object
	public void draw(Graphics g, int catX, int catY)
	{
		Graphics2D g2 = (Graphics2D) g;
		int x=catX;
		int y=catY;
		
		// Draw the head
		g2.setColor(Color.lightGray);
		g2.fillOval(x, y, HEAD_DIMENSION, HEAD_DIMENSION);
		
		// Draw the eyes
		g2.setColor(Color.yellow);
		x = catX + EYE_X; 
		y = catY + EYE_Y;
		g2.fillOval(x, y, EYE_WIDTH, EYE_HEIGHT);
		x += EYE_SEPARATION;
		g2.fillOval(x, y, EYE_WIDTH, EYE_HEIGHT);
		
		// Draw the mouth
		g2.setColor(Color.red);
		x = catX + MOUTH_X;
		y = catY + MOUTH_Y;
		g2.fillOval(x, y, MOUTH_WIDTH, MOUTH_HEIGHT);
		g2.setColor(Color.black);
		
		//draw nose
		g2.setColor(Color.pink);
		x = catX + NOSE_X;
		y = catY + NOSE_Y;
		g2.drawPolygon(new int[] {x-10, x+10, x}, new int[] {y-10, y-10, y}, 3);
		
		//draw ear 1
		g2.setColor(Color.gray);
		x = catX + EAR_X;
		y = catY + EAR_Y;
		g2.drawPolygon(new int[] {x-25, x+15, x}, new int[] {y-25, y-15, y}, 3);
		
		//inner ear 1
		g2.setColor(Color.pink);
		g2.drawPolygon(new int[] {x-20, x+10, x}, new int[] {y-22, y-12, y-5}, 3);
		
		//draw ear 2
		g2.setColor(Color.gray);
		x = 150;
		y = 80;
		g2.drawPolygon(new int[] {x, x-25, x+15}, new int[] {y, y-25, y-15}, 3);
				
		//inner ear 2
		g2.setColor(Color.pink);
		g2.drawPolygon(new int[] {x-20, x+10, x}, new int[] {y-22, y-12, y-5}, 3);
		
		// Meow text appears below cat head, +10 places below 
		// so it doesn't overlap the drawing
		g2.drawString("Mewo!", catX, catY+HEAD_DIMENSION+10);
	}
}
