package problem_5;

public class Coordinate {
	private int row,column;
	
	public Coordinate(String location) {
		String[] parts = location.split("(?<=\\D)(?=\\d)");
		row = (int)parts[0].charAt(0)-96;
		column = Integer.parseInt(parts[1]);
	}
	
	public int getRow() {
		return row;
	}
	
	public int getColumn() {
		return column;
	}
	
	public String toString() {
		return String.format("Row %s, column %s", row, column);
	}
}
