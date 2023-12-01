package problem_6;

public class TetrominoTFactory extends TetrominoFactory{
	public Polyomino[] getOrientations() {
		Polyomino[] positions = new Polyomino[4];
		positions[0] = new Polyomino(new boolean[][] {{true,true,true},{false,true,false}});
		positions[1] = new Polyomino(new boolean[][] {{false,true},{true,true},{false,true}});
		positions[2] = new Polyomino(new boolean[][] {{true,false},{true,true},{true,false}});
		positions[3] = new Polyomino(new boolean[][] {{false,true,false},{true,true,true}});

		return positions;
	}
	
}
