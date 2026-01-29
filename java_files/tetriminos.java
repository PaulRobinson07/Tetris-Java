//class that holds the data for all the shapes and rotations of the tetrimino
public class tetriminos {
	int[][][] o = {
		{
			{0,0,0,0},
			{0,1,1,0},
			{0,1,1,0},
			{0,0,0,0}
		}
	};
	int[][][] l = {
		{
			{0,2,0,0},
			{0,2,0,0},
			{0,2,0,0},
			{0,2,0,0}
		},
		{
			{0,0,0,0},
			{2,2,2,2},
			{0,0,0,0},
			{0,0,0,0}
		},
		{
			{0,0,2,0},
			{0,0,2,0},
			{0,0,2,0},
			{0,0,2,0}
		},
		{
			{0,0,0,0},
			{0,0,0,0},
			{2,2,2,2},
			{0,0,0,0}
		}
	};
	int[][][] s = {
		{
			{0,0,0,0},
			{0,3,3,0},
			{3,3,0,0},
			{0,0,0,0}
		},
		{
			{3,0,0,0},
			{3,3,0,0},
			{0,3,0,0},
			{0,0,0,0}
		}
	};
	int[][][] z = {
		{
			{4,4,0,0},
			{0,4,4,0},
			{0,0,0,0},
			{0,0,0,0}
		},
		{
			{0,0,4,0},
			{0,4,4,0},
			{0,4,0,0},
			{0,0,0,0}
		}
	};
	int[][][] L = {
		{
			{5,0,0,0},
			{5,0,0,0},
			{5,5,0,0},
			{0,0,0,0}
		},
		{
			{5,5,5,0},
			{5,0,0,0},
			{0,0,0,0},
			{0,0,0,0}
		},
		{
			{0,5,5,0},
			{0,0,5,0},
			{0,0,5,0},
			{0,0,0,0}
		},
		{
			{0,0,0,0},
			{0,0,5,0},
			{5,5,5,0},
			{0,0,0,0}
		}
	};
	int[][][] J = {
		{
			{0,0,6,0},
			{0,0,6,0},
			{0,6,6,0},
			{0,0,0,0}
		},
		{
			{6,6,6,0},
			{0,0,6,0},
			{0,0,0,0},
			{0,0,0,0}
		},
		{
			{6,6,0,0},
			{6,0,0,0},
			{6,0,0,0},
			{0,0,0,0}
		},
		{
			{0,0,0,0},
			{6,0,0,0},
			{6,6,6,0},
			{0,0,0,0}
		}
	};
	int[][][] T = {
		{
			{0,7,0,0},
			{7,7,7,0},
			{0,0,0,0},
			{0,0,0,0}
		},
		{
			{0,7,0,0},
			{0,7,7,0},
			{0,7,0,0},
			{0,0,0,0}
		},
		{
			{0,0,0,0},
			{7,7,7,0},
			{0,7,0,0},
			{0,0,0,0}
		},
		{
			{0,7,0,0},
			{7,7,0,0},
			{0,7,0,0},
			{0,0,0,0}
		}
	};

	//gets the value of a tetrimino at a certain point with rotation R
	public int get_tetrimino(int r, int x, int y) {
		switch (main.gr.current_piece) {
			case 1:
				return o[r][x][y];
			case 2:
				return l[r][x][y];
			case 3:
				return s[r][x][y];
			case 4:
				return z[r][x][y];
			case 5:
				return L[r][x][y];
			case 6:
				return J[r][x][y];
			case 7:
				return T[r][x][y];
			default:
				return -1;
		}
	}

	//gets the number of rotations the current piece has
	public int get_tetrimino_rotations() { 
		switch (main.gr.current_piece) {
			case 1:
				return o.length;
			case 2:
				return l.length;
			case 3:
				return s.length;
			case 4:
				return z.length;
			case 5:
				return L.length;
			case 6:
				return J.length;
			case 7:
				return T.length;
			default:
				return -1;
		}
	}
}
