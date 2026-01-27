import java.awt.event.*;

public class input implements KeyListener {
	boolean[] keys = new boolean[255];

	@Override
	public void keyTyped(KeyEvent e) {
		//
	}
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}
	@Override
	public void keyReleased(KeyEvent e) {
		//System.out.print("\033[H\033[2J");
		keys[e.getKeyCode()] = false;
	}
}
