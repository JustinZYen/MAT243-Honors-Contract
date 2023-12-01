package problem_6;

public class TriominoIFactory extends TriominoFactory{
	public Polyomino[] getOrientations() {
		Polyomino[] positions = new Polyomino[2];
		positions[0] = new Polyomino(new boolean[][] {{true,true,true}});
		positions[1] = new Polyomino(new boolean[][] {{true}, {true},{true}});
		return positions;
	}
}
