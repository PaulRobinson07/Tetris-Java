import java.awt.*;
import javax.swing.*;

import java.net.URL;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//starting class that runs everything at the start and handles user input
public class main {
	//makes the gameplay area
	public static graphics gr = new graphics();
	public static score_counter s = new score_counter("Score: " + gr.score);
	//gets the class that controls user inputs
	public static input inputs = new input();

    // main function where everthing starts
    public static void main(String[] args) {
        // Declaring a Frame and Label
        Frame frame = new Frame("Tetris");
	
		//starts the game loop that runs every frame	
		gr.startGameThread();
		s.startThread();
		
		//tells the computer that the window needs all user input data while the game is focused
		frame.addKeyListener(inputs);

		//dimensions of the frame
		final int WIDTH = gr.TILESIZE*14;
		final int HEIGHT = gr.TILESIZE*20;
		frame.setLayout(new BoxLayout(frame, BoxLayout.X_AXIS));
		//adds the draw function to the frame
		gr.setPreferredSize(new Dimension(gr.TILESIZE*10, gr.TILESIZE*20));
		s.setPreferredSize(new Dimension(gr.TILESIZE*4, gr.TILESIZE*20));
		frame.add(gr);
		frame.add(s);
		//gets the icon image for the top left
		ImageIcon icon = new ImageIcon("../images/tetris.png");

		frame.setIconImage(icon.getImage());
		//sets the dimensions of the window
        frame.setSize(WIDTH+gr.TILESIZE, HEIGHT+gr.TILESIZE); 

		//makes the window visible
        frame.setVisible(true);

		//detects if the window is closed
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
				//if the user tries to close the program ceases to exist
                System.exit(0);
            }
        });
	}
}
