import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

public class graphics extends JPanel implements Runnable {
	//gets the game and color variables/methods
	game_area game = new game_area();
	colors game_colors = new colors();
	tetriminos t = new tetriminos();
	Thread gameThread;
	//variables for the player to controller the pieces
	int x = 5;
	int y = 0;
	//sets the size of each of the tiles
	final short TILESIZE = 32;
	//draw to screen function
	public void paintComponent (Graphics g){
		super.paintComponent(g);
		//iterates through every tile to draw it
		for (int i=0; i<10;i++) {
			for (int j=0; j<20; j++) {
				pick_draw_tile(i,j,g);
			}
		}
	}
	//function that finds the tile in the game space, determines color, and draws it
	public void pick_draw_tile(int i, int j, Graphics g) {
		//gets the value of the game space
		switch (game.world[i][j]) {
			//switches to draw and get the right color
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
	//inital code that starts the timer for game logic
	public void startGameThread() {
		game.makeWorld();
		gameThread = new Thread(this);
		gameThread.start();
	}
	//loop that runs every frame
	@Override
	public void run() {
		while(true) {
			//changes the position of the current tetrimino
			if (y<19) {
				move_shape(0,1);
			}
			//redraws the screen for the next frame
			repaint();
			//tries to wait to make another frame
			try {
				//waits a specified amount of time
				Thread.sleep(300);
			} catch(InterruptedException e) {
				//prints out the error if the frame fails to run
				e.printStackTrace();
			}
		}
	}
	public void move_shape(int dx, int dy) {
		for (int i=0; i<4; i++) {
			for (int j=0; j<4; j++) {
				if (t.square[0][i][j]!=0) {
					game.world[i+x][j+y] = 0;
				}
			}
		}
		for (int i=0; i<4; i++) {
			for (int j=0; j<4; j++) {
				if (t.square[0][i][j]!=0) {
					int ax = i+x+dx;
					int ay = j+y+dy;
					if (!(ax<0 || ax>9 || ay<0 || ay>19)) {
						game.world[i+x+dx][j+y+dy] = t.square[0][i][j];
					}
					else {
						return;
					}
				}
			}
		}
		y+=dy;
		x+=dx;
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
}
