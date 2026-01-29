import java.awt.*;

//class that stores all the colors used to render
public class colors {
	//initalizes all the variables
	Color white;
	Color faded_white;

	Color yellow;
	Color light_yellow;

	Color blue;
	Color light_blue;

	Color red;
	Color light_red;

	Color green;
	Color light_green;

	Color orange;
	Color light_orange;

	Color pink;
	Color light_pink;

	Color purple;
	Color light_purple;

	Color black;
	Color lighter_black;

	//sets the rgba values of every color with transparency given through the constructor
	colors(int transparency) {
		white= new Color(255, 255, 255, transparency);
		faded_white = new Color(252, 238, 238, transparency);

		yellow = new Color(235, 204, 152, transparency);
		light_yellow = new Color(243, 223, 191, transparency);

		blue = new Color(45, 130, 183, transparency);
		light_blue = new Color(91, 168, 215, transparency);
		
		red = new Color(225, 81, 90, transparency);
		light_red = new Color(235, 138, 144, transparency);

		green = new Color(66, 226, 184, transparency);
		light_green = new Color(131, 236, 208, transparency);

		orange = new Color(223, 111, 83, transparency);
		light_orange = new Color(230, 143, 121, transparency);

		pink = new Color(234, 133, 138, transparency);
		light_pink = new Color(240, 168, 171, transparency);

		purple = new Color(141, 104, 135, transparency);
		light_purple = new Color(158, 125, 153, transparency);

		black = new Color(32, 32, 32, transparency);
		lighter_black= new Color(72, 72, 72, transparency);
	}
}

