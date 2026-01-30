import java.awt.*;
import javax.swing.*;

public class score_counter extends JPanel {
	static JLabel l;
	score_counter(String text) {
		l = new JLabel();
		l.setText(text);
		this.add(l);
	}
	public void update_score(int score) {
		l.setText("Score: " + score);
	}
}
