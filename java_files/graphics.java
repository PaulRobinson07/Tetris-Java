import java.awt.*;
import javax.swing.*;
import java.util.Arrays;

//class that runs all the graphics and loop for the game
public class graphics extends JPanel implements Runnable {
	//gets the game and color variables/methods
	game_area game = new game_area();

	//makes all the colors
	colors game_colors = new colors();

	//variables that hold the rotation and shape of all the tetriminos
	tetriminos t = new tetriminos();
	
	//thread used to update the game every frame
	Thread gameThread;

	//variables for the player to controller the pieces
	int x = 5;
	int y = 0;

	//sets the size of each of the tiles
	final short TILESIZE = 32;

	//draw to screen function
	public void paintComponent (Graphics g){
		//overwries the JPanel to start drawing things through the class
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
		//makes the array that holds all the data for the game area
		game.makeWorld();

		//starts the game loop
		gameThread = new Thread(this);
		gameThread.start();
	}

	//loop that runs every frame
	@Override
	public void run() {
		//keeps running the thread
		while(true) {
			//moves the tetrimino down one tile
			move_shape(0,1);

			//redraws the screen for the current frame
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

	//function that allows tetriminoes to move and does the proper collision checks for them
	public void move_shape(int dx, int dy) {
		//temporary variable for checking movement collisions
		int[][] swap_world = new int[10][20];
		//copies the game world
		for (int a = 0; a<10;a++) {
			for (int b=0; b<20;b++) {
				swap_world[a][b] = game.world[a][b];
			}
		}
		//loops over the tetrimino's tiles to remove the current position's data
		for (int i=0; i<4; i++) {
			for (int j=0; j<4; j++) {
				//checks if the tile is occupied in the tetrimino's data
				if (t.square[0][j][i]!=0) {
					//resets the data in the correpsonding tile
					swap_world[i+x][j+y] = 0;
				}
			}
		}
		//loops over the tetrimino's tiles to check if the piece can move
		for (int i=0; i<4; i++) {
			for (int j=0; j<4; j++) {
				//checks if a tetrimino should be drawn
				if (t.square[0][j][i]!=0) {
					//temporary variables storing position of the current tile to be checked
					int ax = i+x+dx;
					int ay = j+y+dy;

					//doesn't allow piece to leave the left or right borders
					if (ax<0 || ax>9) {
						//doesn't move the piece and resets to the previous game area
						return;
					}

					//makes a new piece if the last one reached the bottom
					if (ay<0 || ay>19) {
						y=0;
						//doesn't move the piece and resets to the previous game area
						return;
					}

					//doesn't allow piece to move if the next spot is already occupied
					if (swap_world[i+x+dx][j+y+dy]!=0) {
						//if the tile is moving down a new piece is made
						if (dy!=0) {
							y=0;
						}
						//doesn't move the piece and resets to the previous game area
						return;
					}

					//sets the tile to be occupied
					swap_world[i+x+dx][j+y+dy] = t.square[0][j][i];
				}
			}
		}

		//updates the player's position
		x+=dx;
		y+=dy;

		//updates the world
		game.world = Arrays.copyOf(swap_world,swap_world.length);
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
