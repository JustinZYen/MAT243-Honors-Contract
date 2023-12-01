package problem_6;
import java.util.*;
public class Problem6 {
	private static PolyominoFactory factory;
	private static char currentChar = 'a';
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)){
			System.out.println("Choose polyomino type: ");
			System.out.println("a) Domino");
			System.out.println("b) L-shaped triomino");
			System.out.println("c) I-shaped triomino");
			System.out.println("d) T-shaped tetromino");
			System.out.println("e) L-shaped tetromino");
			while (factory == null) {
				String option = sc.next();
				switch (option) {
					case "a": 
						factory  = new DominoFactory();
						break;
					case "b":
						factory = new TriominoLFactory();
						break;
					case "c":
						factory = new TriominoIFactory();
						break;
					case "d":
						factory = new TetrominoTFactory();
						break;
					case "e":
						factory = new TetrominoLFactory();
						break;
					default:
						System.out.println("invalid");
				}
			}
			System.out.println("Enter height of board: ");
			int height = sc.nextInt();
			System.out.println("Enter width of board: ");
			int width = sc.nextInt();
			char[][] board = new char[height][width];
			setUpBoard(board);
			//printBoard(board);
			if (fillBoard(board)) {
				printBoard(board);
			} else {
				System.out.println("Could not fill board with current polyomino type");
			}
		}
	}
	
	private static boolean fillBoard(char[][] board) {
		if ((board[0].length * board.length) % factory.getSize() != 0) {
			return false;
		}
		else {
			return fillBoardRecur(board);
		}
	}

	private static boolean fillBoardRecur(char[][] board) {
		int[] current = getFirstEmpty(board);
		// Case: Board has been filled
		if (current[0] == -1) {
			return true;
		} else {
			for (Polyomino p:factory.getOrientations()) {
				if (canFit(board,current,p)) {
					editBoard(board, current, p, true);
					currentChar++;
					if (fillBoardRecur(board) == true) {
						return true;
					} else {
						// If unable to fill board with current orientation, backtracks
						editBoard(board, current, p, false);
						currentChar--;
					}
				}
			}
			return false;
		}
	}
	
	private static boolean canFit(char[][] board, int[] location, Polyomino p) {
		boolean[][] positions = p.getPositions();
		// Find location of head (will be what gets placed at the targeted location)
		int[] headLocation = {0,0};
		for (int i = 0; i < positions[0].length; i++) {
			if (positions[0][i] == true) {
				headLocation[1] = i;
				break;
			}
		}
		for (int i = 0; i < positions.length; i++) {
			for (int j = 0; j < positions[0].length; j++) {
				if (positions[i][j] == true) {
					// Check to make sure every location that you intend to fill is actually empty
					int boardRow = location[0]-headLocation[0]+i;
					int boardColumn = location[1]-headLocation[1]+j;
					if (boardRow >= 0 && boardRow < board.length && boardColumn >= 0 && boardColumn < board[0].length) {
						if (Character.isLetter(board[boardRow][boardColumn])) {
							return false;
						}
					} else {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	private static void editBoard(char[][] board, int[] location, Polyomino p, boolean adding) {
		boolean[][] positions = p.getPositions();
		// Find location of head (will be what gets placed at the targeted location)
		int[] headLocation = {0,0};
		for (int i = 0; i < positions[0].length; i++) {
			if (positions[0][i] == true) {
				headLocation[1] = i;
				break;
			}
		}
		for (int i = 0; i < positions.length; i++) {
			for (int j = 0; j < positions[0].length; j++) {
				if (positions[i][j] == true) {
					int boardRow = location[0]-headLocation[0]+i;
					int boardColumn = location[1]-headLocation[1]+j;
					if (adding) {
						board[boardRow][boardColumn] = currentChar;
					} else {
						board[boardRow][boardColumn] = '+';
					}
				}
			}
		}
	}

	
	private static int[] getFirstEmpty(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (!Character.isLetter(board[i][j])) {
					return new int[] {i,j};
				}
			}
		}
		// Return (-1,-1) if the board has no more empty spaces
		return new int[] {-1,-1};
	}
	
	private static void printBoard(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	
	private static void setUpBoard(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = '+';
			}
		}
	}
}
