public class game_area {
	int[][] world = new int[10][20];
	public void makeWorld() {
		for (int i=0; i<10;i++) {
			for (int j=0; j<20; j++) {
				if (i==0 || i==9 || j==0 || j==19) { 
					world[i][j] = 1;
				}
				else {
					world[i][j] = 0;
				}
			}
		}
		for (int i=0;i<10;i++) {
			world[i][1] = i;
		}
	}
}
