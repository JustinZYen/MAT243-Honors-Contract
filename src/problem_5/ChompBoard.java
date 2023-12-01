package problem_5;

public class ChompBoard {
	private boolean[][] board;
	
	public ChompBoard(int height, int width) {
		if (height > 26) {
			throw new IllegalArgumentException("Height too big!");
		}
		board = new boolean[height][width];		
		for (boolean[] row:board) {
			for (int i = 0; i < row.length; i++) {
				row[i] = true;
			}
		}
	}
	
	public boolean isValidMove(Coordinate coor) {
		if (board.length < coor.getRow() || board[0].length < coor.getColumn()) {
			return false;
		} else {
			return board[coor.getRow()-1][coor.getColumn()-1] == true;
		}
	}
	
	public boolean remove(Coordinate coor) {
		for (int i = coor.getRow()-1; i < board.length; i++) {
			for (int j = coor.getColumn()-1; j < board[i].length; j++) {
				if (board[i][j] == true) {
					board[i][j] = false;
				} else {
					break;
				}
			}
		}
		return isEmpty();
	}
	
	private boolean isEmpty() {
		return board[0][0] == false;
	}
	
	public String toString() {
		int numberSpacing = (int)Math.log10(board[0].length)+2;
		String result = "  ";
		for (int i = 0; i < board[0].length;i++) {
			result += String.format("%"+numberSpacing+"d",(i+1));
		}
		result += System.lineSeparator();
		for (int i = 0; i < board.length; i++) {
			result += (char)(i+97)+" ";
			for (boolean current:board[i]) {
				if (current == true) {
					result += String.format("%"+numberSpacing+"s","O");
				} else {
					result += String.format("%"+numberSpacing+"s","*");
				}
			}
			if (i < board.length-1) {
				result += System.lineSeparator();
			}
		}
		return result;
	}
	
	
}
