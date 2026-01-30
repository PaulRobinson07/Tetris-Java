import java.awt.*;
import javax.swing.*;
import java.util.Arrays;

//class that runs all the graphics and loop for the game
public class graphics extends JPanel implements Runnable {
	//gets the game and color variables/methods
	game_area game = new game_area();

	//makes all the colors
	colors game_colors = new colors(255);
	colors game_colors_t = new colors(80);

	//variables that hold the rotation and shape of all the tetriminos
	tetriminos t = new tetriminos();
	
	//thread used to update the game every frame
	Thread gameThread;

	//variables for the player to controller the pieces
	int x = 5;
	int y = 0;

	int score = 0;
	int level = 0;
	
	//sets the current piece (randomly picked from one of seven possible pieces)
	int current_piece = (int)(Math.random()*7)+1;
	
	//rotation angle (times 90 deg)
	int r = 0;
	
	//sets the size of each of the tiles
	final short TILESIZE = 64;
	boolean is_dark_mode = true;

	//draw to screen function
	public void paintComponent (Graphics g){
		//overwries the JPanel to start drawing things through the class
		super.paintComponent(g);

		//iterates through every tile to draw it
		for (int i=0; i<10;i++) {
			for (int j=0; j<20; j++) {
				//pick_draw_tile(i,j,g);
				pick_color(i,j,g,game_colors,game.world[i][j]);
			}
		}

		//draws the hard drop location
		draw_hard_drop(x,hard_drop(),g);
		main.s.update_score(score);
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
			move_shape(0,1,0);

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
	public void move_shape(int dx, int dy, int rotation) {
		//temporary variable for storing the next rotation matrix value
		int next_rotate = r+rotation;	

		//clamps it between the size of the array and loops back over if it goes outside of it
		if (next_rotate>t.get_tetrimino_rotations()-1) {next_rotate=0;}
		if (next_rotate<0) {next_rotate=t.get_tetrimino_rotations()-1;}

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
				if (t.get_tetrimino(r,j,i)!=0) {
					//resets the data in the correpsonding tile
					swap_world[i+x][j+y] = 0;
				}
			}
		}

		//loops over the tetrimino's tiles to check if the piece can move
		for (int i=0; i<4; i++) {
			for (int j=0; j<4; j++) {
				//checks if a tetrimino should be drawn
				if (t.get_tetrimino(next_rotate,j,i)!=0) {
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
						//resets positioning variables
						y=0;
						x=5;
						r=0;

						//removes full lines
						game.check_lines();

						//gets a new piece to place
						current_piece = (int)(Math.random()*7)+1;

						//doesn't move the piece and resets to the previous game area
						return;
					}

					//doesn't allow piece to move if the next spot is already occupied
					if (swap_world[i+x+dx][j+y+dy]!=0) {
						//if the tile is moving down a new piece is made
						if (dy!=0) {
							//resets positioning variables
							y=0;
							x=5;
							r=0;

							//removes full lines
							game.check_lines();

							//gets a new piece to place
							current_piece = (int)(Math.random()*7)+1;
						}
						//doesn't move the piece and resets to the previous game area
						return;
					}

					//sets the tile to be occupied
					swap_world[i+x+dx][j+y+dy] = t.get_tetrimino(next_rotate,j,i);
				}
			}
		}

		//updates the player's position and rotation
		x+=dx;
		y+=dy;
		r=next_rotate;

		//updates the world
		game.world = Arrays.copyOf(swap_world,swap_world.length);
	}

	//draws the location of the hard drop
	public void draw_hard_drop(int dx, int dy, Graphics g) {
		//loops over the current piece
		for (int i=0; i<4; i++) {
			for (int j=0; j<4; j++) {
				//gets if the tile should be drawn
				if (t.get_tetrimino(r,j,i)!=0) {
					//draws the tile hard drop
					pick_color(dx+i,dy+j,g,game_colors_t,current_piece);
				}
			}
		}
	}

	//draws the tile with the right color based on the current piece
	public void pick_color(int location_x, int location_y, Graphics g, colors c, int swap_var) {
		//gets the color of current piece and then draws the pieces
		switch (swap_var) {
			case 0:
				if (is_dark_mode) {
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

	//gets the location that the lowest place the piece can go before it hits the bottom or another already full tile
	public int hard_drop() {
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
				if (t.get_tetrimino(r,j,i)!=0) {
					//resets the data in the correpsonding tile
					swap_world[i+x][j+y] = 0;
				}
			}
		}
		
		//loops over every y value to find the first full one
		for (int a=0;a<20;a++) {
			//loops over the tetrimino's tiles to check if the piece can move
			for (int i=0; i<4; i++) {
				for (int j=0; j<4; j++) {
					//checks if a tetrimino tile should exist
					if (t.get_tetrimino(r,j,i)!=0) {
						//temporary variable storing position of the current tile to be checked
						int ay = j+a;
						
						//detects if the hard drop has hit the bottom (above)
						if (ay<0 || ay>19) {
							//returns the value of the hard drop
							return a-1;
						}
						
						//detects if a piece is in the spot
						if (swap_world[i+x][j+a]!=0) {
							//returns the value of the hard drop (above)
							return a-1;
						}
					}
				}
			}
		}

		//failure of method
		return 0;
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
