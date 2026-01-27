import java.awt.event.*;

public class input implements KeyListener {
	@Override
	public void keyTyped(KeyEvent e) {
		//
	}
	@Override
	public void keyPressed(KeyEvent e) {
		//user control inputs
		switch(e.getKeyCode()) {
			case 65:
				//move tetrimino left
				main.gr.x -=1;
			break;
			case 68:
				//move tetrimino left
				main.gr.x +=1;
			break;
			case 81:
				//rotate the tetrimino counterclockwise
			break;
			case 69:
				//rotate the tetrimino clockwise
			break;
			case 32:
				//move tetrimino to bottom 
			break;
			case 8:
				//ends the program
				System.exit(0);
			break;
		}
		main.gr.repaint();
	}
	@Override
	public void keyReleased(KeyEvent e) {
		//System.out.print("\033[H\033[2J");
	}
}
