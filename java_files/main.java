import java.awt.*;
import javax.swing.*;

import java.net.URL;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//starting class that runs everything at the start and handles user input
public class main {
	public static input inputs = new input();
    // main function where everthing starts
    public static void main(String[] args) {
        // Declaring a Frame and Label
        Frame frame = new Frame("Tetris");
	
		//adds the drawing function to the main file
		graphics gr = new graphics();

		//starts the game loop that runs every frame	
		gr.startGameThread();
		
		//input inputs = new input();
		frame.addKeyListener(inputs);

		//dimensions of the frame
		final int WIDTH = gr.TILESIZE*10;
		final int HEIGHT = gr.TILESIZE*20;

		//adds the draw function to the frame
		frame.add(gr);

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
