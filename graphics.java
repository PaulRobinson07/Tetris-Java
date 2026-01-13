import java.awt.*;
import javax.swing.*;

public class graphics extends JPanel {
	game_area game = new game_area();
	colors game_colors = new colors();

	final short TILESIZE = 64;
	//draw function
	public void paintComponent (Graphics g){
		super.paintComponent(g);
		game.makeWorld();
		g.setColor(Color.BLUE);
		for (int i=0; i<10;i++) {
			for (int j=0; j<20; j++) {
				switch (game.world[i][j]) {
					case 1:
						tile(i,j,g,game_colors.yellow,game_colors.light_yellow);
					break;
					case 2:
						tile(i,j,g,game_colors.blue,game_colors.light_blue);
					break;
					case 3:
						tile(i,j,g,game_colors.red,game_colors.light_red);
					break;
					case 4:
						tile(i,j,g,game_colors.green,game_colors.light_green);
					break;
					case 5:
						tile(i,j,g,game_colors.orange,game_colors.light_orange);
					break;
					case 6:
						tile(i,j,g,game_colors.pink,game_colors.light_pink);
					break;
					case 7:
						tile(i,j,g,game_colors.purple,game_colors.light_purple);
					break;
					default:
						tile(i,j,g,game_colors.white,game_colors.faded_white);
					break;
				}
			}
		}
	}
	public void tile (int x, int y, Graphics g, Color c1, Color c2) {
		g.setColor(c2);
		g.fillRect(x*TILESIZE,y*TILESIZE,TILESIZE,TILESIZE);
		g.setColor(c1);
		g.fillRect(x*TILESIZE+4,y*TILESIZE+4,TILESIZE-8,TILESIZE-8);
	}
}
