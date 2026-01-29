import java.awt.*;

//class that stores all the transpareant colors used to render
public class transparent_colors {
	//value from 0-255 that determines the transparency of these colors
	int t= 80;

	Color white= new Color(255, 255, 255, t);
	Color faded_white = new Color(252, 238, 238, t);

	Color yellow = new Color(235, 204, 152, t);
	Color light_yellow = new Color(243, 223, 191, t);

	Color blue = new Color(45, 130, 183, t);
	Color light_blue = new Color(91, 168, 215, t);
	
	Color red = new Color(225, 81, 90, t);
	Color light_red = new Color(235, 138, 144, t);

	Color green = new Color(66, 226, 184, t);
	Color light_green = new Color(131, 236, 208, t);

	Color orange = new Color(223, 111, 83, t);
	Color light_orange = new Color(230, 143, 121, t);

	Color pink = new Color(234, 133, 138, t);
	Color light_pink = new Color(240, 168, 171, t);

	Color purple = new Color(141, 104, 135, t);
	Color light_purple = new Color(158, 125, 153, t);

	Color black = new Color(7, 0, 77, t);
	Color lighter_black= new Color(14, 0, 163, t);
}

