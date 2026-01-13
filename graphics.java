import java.awt.*;
import javax.swing.*;

public class graphics extends JPanel {
	final short TILESIZE = 32;
	//draw function
	public void paintComponent (Graphics g){
		super.paintComponent(g);
		setForeground(Color.BLUE);
		tile(0,0,g);
	}
	public void tile (int x, int y, Graphics g) {
		super.paintComponent(g);
		g.drawRect(x*TILESIZE,y*TILESIZE,TILESIZE,TILESIZE);
		g.fillRect(x*TILESIZE,y*TILESIZE,TILESIZE,TILESIZE);
	}
}
