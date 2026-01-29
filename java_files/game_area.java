//class that makes the world area to store the gamespace data
public class game_area {
	//defines the world
	int[][] world = new int[10][20];

	//inital method that defines the empty world area
	public void makeWorld() {
		//iterates over the entire gamespace to fill it
		for (int i=0; i<10;i++) {
			for (int j=0; j<20; j++) {
				world[i][j] = 0;
			}
		}
	}

	//method for checking if lines need to be cleared
	public void check_lines() {
		//variable used to store the number of spaces filled on a given line
		int line_spaces_filled = 0;

		//loops over every tile skipping the first line because it should never be full
		for (int i=1; i<20;i++) {
			for (int j=0; j<10; j++) {
				//checks if the tile is empty
				if (main.gr.game.world[j][i]==0) {
					//skips to the next line
					j=10;	
				}
				//adds one tile to the tile count
				else {
					line_spaces_filled++;
				}
			}

			//if the previous loop got a full line, all lines above the current one are moved down
			if (line_spaces_filled==10) {
				for (int a=i;a>1;a--) {
					for (int j=0; j<10; j++) {
						main.gr.game.world[j][a] = main.gr.game.world[j][a-1];
					}
				}
			}

			//the space counter is reset
			line_spaces_filled = 0;
		}
	}
}
