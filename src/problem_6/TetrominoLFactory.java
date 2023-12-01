package problem_6;

public class TetrominoLFactory extends TetrominoFactory{
	public Polyomino[] getOrientations() {
		Polyomino[] positions = new Polyomino[5];
		positions[0] = new Polyomino(new boolean[][] {{true,true,true},{true,false,false}});
		positions[1] = new Polyomino(new boolean[][] {{true,true},{true,false},{true,false}});
		positions[2] = new Polyomino(new boolean[][] {{true,false},{true,false},{true,true}});
		positions[3] = new Polyomino(new boolean[][] {{true,true,true},{false,false,true}});
		positions[4] = new Polyomino(new boolean[][] {{true,false,false},{true,true,true}});
		return positions;
	}
}
