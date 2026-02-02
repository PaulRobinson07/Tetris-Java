import java.awt.event.*;

//class that gets the user's input and acts on it
public class input implements KeyListener {
	//nothing yet for simple typing	
	@Override
	public void keyTyped(KeyEvent e) {
		//
	}
	//acts when the key is simply pressed
	@Override
	public void keyPressed(KeyEvent e) {
		//user control inputs
		switch(e.getKeyCode()) {
			case 65:
				//move tetrimino left
				main.gr.move_shape(-1,0,0);
			break;
			case 68:
				//move tetrimino right
				main.gr.move_shape(1,0,0);
			break;
			case 81:
				//rotate the tetrimino counterclockwise
				main.gr.move_shape(0,0,-1);
			break;
			case 82: 
				//toggles the dark mode
				main.gr.is_dark_mode = !main.gr.is_dark_mode;
			break;
			case 83: 
				//rotate the tetrimino down once 
				main.gr.move_shape(0,1,0);
			break;
			case 69:
				//rotate the tetrimino clockwise
				main.gr.move_shape(0,0,1);
			break;
			case 32:
				//move tetrimino to bottom 
				main.gr.move_shape(0,main.gr.hard_drop()-main.gr.y,0);

				//causes another update to force a new tetrimino to be made
				main.gr.move_shape(0,1,0);
			break;
			case 16:
				if (main.gr.hold_can_swap) {
					//loops over the tetrimino's tiles to remove the current position's data
					for (int i=0; i<4; i++) {
						for (int j=0; j<4; j++) {
							//checks if the tile is occupied in the tetrimino's data
							if (main.gr.t.get_tetrimino(main.gr.r,j,i,main.gr.current_piece)!=0) {
								//resets the data in the correpsonding tile
								main.gr.game.world[i+main.gr.x][j+main.gr.y] = 0;
							}
						}
					}
					if (main.gr.hold ==0) {
						main.gr.hold = main.gr.bag_0.p.get(0); 
						//gets a new piece to place
						main.gr.bag_0.new_piece();
					}
					else  {
						main.gr.current_piece = main.gr.hold;
						main.gr.hold = main.gr.bag_0.p.get(0);
						main.gr.bag_0.p.set(0,main.gr.current_piece);
					}

					main.gr.hold_can_swap = false;

					//resets positioning variables
					main.gr.y=0;
					main.gr.x=5;
					main.gr.r=0;

					main.gr.current_piece = main.gr.bag_0.p.get(0);
				}
			break;
			case 8:
				//ends the program
				System.exit(0);
			break;
		}
		//draws a new frame for the updated game
		main.gr.repaint();
	}
	//nothing yet for releases
	@Override
	public void keyReleased(KeyEvent e) {
		//
	}
}
