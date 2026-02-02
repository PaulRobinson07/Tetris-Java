import java.awt.*;
import javax.swing.*;

public class score_counter extends JPanel implements Runnable {
	static JLabel score_text;
	static JLabel hold_text;
	static JPanel bag_pieces;
	final int TILESIZE = (int)(main.gr.TILESIZE/2);

	//runs on creation of class
	score_counter(String text) {
		score_text = new JLabel();
		hold_text = new JLabel();
		bag_pieces = new JPanel();
		score_text.setText(text);
		hold_text.setText("Hold:");
		this.add(score_text);
		this.add(hold_text);
		this.add(bag_pieces);
	}

	//draws the jpanel to screen
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		for (int i=0; i<7;i++) {
			draw_shape(i,g);
		}
		draw_hold(g);
	}

	//starts a thread to update the next piece every frame
	public void startThread() {
		Thread t = new Thread(this);
		t.start();
	}

	//the thread that runs every frame
	@Override
	public void run() {
		while(true) {
			repaint();
			try {
				Thread.sleep(30);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	//draws a shape at a given point
	public void draw_shape(int y, Graphics g) { 
		for (int i=0;i<4;i++) {
			for (int j=0;j<4;j++) {
				int a = main.gr.t.get_tetrimino(0,j,i,main.gr.bag_0.p.get(y));
				if (a!=0) {
					//tile(i,j+y*5,g,main.gr.game_colors.light_red,main.gr.game_colors.red);
					pick_color(i,j+y*5+3,g,main.gr.game_colors,a);
				}
			}
		}
	}
	public void draw_hold(Graphics g) {
		for (int i=0;i<4;i++) {
			for (int j=0;j<4;j++) {
				int a = main.gr.t.get_tetrimino(0,j,i,main.gr.hold);
				if (a!=0) {
					//tile(i,j+y*5,g,main.gr.game_colors.light_red,main.gr.game_colors.red);
					pick_color(i+4,j+3,g,main.gr.game_colors,a);
				}
			}
		}
	}
	public void update_score(int score) {
		score_text.setText("Score: " + score);
	}
	//function used for drawing tiles onto the screen
	public void tile (int x, int y, Graphics g, Color c1, Color c2) {
		//sets the outside tile color and draws the tile
		g.setColor(c2);
		g.fillRect(x*TILESIZE,y*TILESIZE,TILESIZE,TILESIZE);

		//sets the inside tile color and draws the tile
		g.setColor(c1);
		g.fillRect(x*TILESIZE+4,y*TILESIZE+4,TILESIZE-8,TILESIZE-8);
	}

	//draws the tile with the right color based on the current piece
	public void pick_color(int location_x, int location_y, Graphics g, colors c, int swap_var) {
		//gets the color of current piece and then draws the pieces
		switch (swap_var) {
			case 0:
				if (main.gr.is_dark_mode) {
					tile(location_x,location_y,g,c.black,c.lighter_black);
				}
				else {
					tile(location_y,location_y,g,c.white,c.faded_white);
				}
			break;
			case 1:
				tile(location_x,location_y,g,c.yellow,c.light_yellow);
			break;
			case 2:
				tile(location_x,location_y,g,c.blue,c.light_blue);
			break;
			case 3:
				tile(location_x,location_y,g,c.red,c.light_red);
			break;
			case 4:
				tile(location_x,location_y,g,c.green,c.light_green);
			break;
			case 5:
				tile(location_x,location_y,g,c.orange,c.light_orange);
			break;
			case 6:
				tile(location_x,location_y,g,c.pink,c.light_pink);
			break;
			case 7:
				tile(location_x,location_y,g,c.purple,c.light_purple);
			break;
		}
	}
}
