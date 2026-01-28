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
			case 69:
				//rotate the tetrimino clockwise
				main.gr.move_shape(0,0,1);
			break;
			case 32:
				//move tetrimino to bottom 
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
