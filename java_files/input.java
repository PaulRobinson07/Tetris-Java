import java.awt.event.*;

public class input implements KeyListener {
	@Override
	public void keyTyped(KeyEvent e) {
		//`
	}
	@Override
	public void keyPressed(KeyEvent e) {
		//
	}
	@Override
	public void keyReleased(KeyEvent e) {
		System.out.print("\033[H\033[2J");
		System.out.println("You released the " + e.getKeyCode() + " key");
	}
}
