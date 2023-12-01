package problem_6;

public class TriominoLFactory extends TriominoFactory{

	@Override
	public Polyomino[] getOrientations() {
		Polyomino[] positions = new Polyomino[4];
		positions[0] = new Polyomino(new boolean[][] {{true,true}, {true,false}});
		positions[1] = new Polyomino(new boolean[][] {{true,false}, {true,true}});
		positions[2] = new Polyomino(new boolean[][] {{false,true}, {true,true}});
		positions[3] = new Polyomino(new boolean[][] {{true,true}, {false,true}});

		return positions;
	}
	
}
