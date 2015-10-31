 import java.awt.Image;
import java.awt.Graphics;

public class DoubleBuffer {
	private Image i;
	private Graphics doubleG;
	
	public DoubleBuffer(Graphics g, Main sauce){
		if(i == null){
			i = sauce.createImage(sauce.getWidth(), sauce.getHeight());
			doubleG = i.getGraphics();
		}
		
		doubleG.setColor(sauce.getBackground());
		doubleG.fillRect(0, 0, sauce.getWidth(), sauce.getHeight());
		
		doubleG.setColor(sauce.getForeground());
		sauce.paint(doubleG);
		
		g.drawImage(i, 0, 0, sauce);
	}
}	