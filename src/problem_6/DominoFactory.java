package problem_6;

public class DominoFactory extends PolyominoFactory{
	public Polyomino[] getOrientations() {
		Polyomino[] positions = new Polyomino[2];
		positions[0] = new Polyomino(new boolean[][] {{true,true}});
		positions[1] = new Polyomino(new boolean[][] {{true},{true}});
		return positions;
	}
	
	public int getSize() {
		return 2;
	}
}
