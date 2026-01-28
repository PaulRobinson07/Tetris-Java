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
}
