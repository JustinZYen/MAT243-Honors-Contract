package problem_5;
import java.util.*;
public class Problem5 {
	public static void main (String[] args) {
		System.out.println("Play Chomp!");
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter height of board: ");
			int height = sc.nextInt();
			System.out.println("Enter width of board: ");
			int width = sc.nextInt();
			ChompBoard board = new ChompBoard(height,width);
			System.out.println(board);
			boolean gameOver = false;
			int currentPlayer = 1;
			while (!gameOver) {
				System.out.println("Player "+currentPlayer+", enter coordinates to remove");
				Coordinate currentMove = new Coordinate(sc.next());
				if (board.isValidMove(currentMove)) {
					gameOver = board.remove(currentMove);
					System.out.println(board);
					// Not sure if this is good implementation
					currentPlayer = 3-currentPlayer;
				} else {
					System.out.println("Invalid move!");
				}
			}
			System.out.println("Player " + currentPlayer + " wins!");
		}
	}
}

