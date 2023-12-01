package problem_3;

import java.util.*;

public class Problem3 {
	/* Operations:
	 * !: not
	 * &: and
	 * |: or
	 * ^: xor
	 * >: conditional
	 * =: biconditional
	*/
	public static void main (String[] args) {
		LinkedList<Character> proposition = new LinkedList<>();
		// Fill up linkedlist with all elements of the compound proposition
		try (Scanner reader = new Scanner(System.in)) {
			System.out.println("Enter compound proposition: ");
			try (Scanner sc = new Scanner(reader.nextLine())) {
				sc.useDelimiter("");
				while (sc.hasNext()) {
					String next = sc.next();
					if (!next.equals(" ")) {
						proposition.add(next.charAt(0));
					}
				}
			}
		}
		if (!validProposition(proposition)) {
			throw new IllegalArgumentException();
		}
		// Test out combinations of truth values
		ArrayList<Character> atoms = getAtoms(proposition);
		boolean isSatisfiable = false;
		for (int i = 0; i < Math.pow(2,atoms.size()); i++) {
			HashMap<Character, Boolean> truthValues = new HashMap<>();
			for (int j = 0; j < atoms.size(); j++) {
				truthValues.put(atoms.get(j), ((i >> j) & 1) == 1);
			}
			LinkedList<Character> testProposition = substituteTruthValues(proposition,truthValues);
			if (evaluate(testProposition) == 'T') {
				System.out.println("Satisfiable with "+truthValues);
				isSatisfiable = true;
				break;
			}
		}
		if (!isSatisfiable) {
			System.out.println("Proposition cannot be satisfied");
		}
	}
	
	/**
	 * Checks if a given proposition is valid (correct number of parentheses)
	 * @param proposition
	 * @return
	 */
	private static boolean validProposition(LinkedList<Character> proposition) {
		Iterator<Character> it = proposition.iterator();
		int parenthesesCount = 0;
		while (it.hasNext()) {
			char current = it.next();
			if (current == '(') {
				parenthesesCount++;
			} else if (current == ')') {
				parenthesesCount--;
				if (parenthesesCount < 0 ) {
					return false;
				}
			}
		}
		return true;
	}
	
	private static ArrayList<Character> getAtoms(LinkedList<Character> proposition) {
		ArrayList<Character> atoms = new ArrayList<>();
		ListIterator<Character> it = proposition.listIterator();
		while (it.hasNext()) {
			char current = it.next();
			if (Character.isLetter(current) && !atoms.contains(current) ) {
				atoms.add(current);
			}
		}
		return atoms;
	}
	
	private static LinkedList<Character> substituteTruthValues(LinkedList<Character> proposition, HashMap<Character,Boolean> truthValues) {
		LinkedList<Character> result = new LinkedList<>();
		for (char current : proposition) {
			if (Character.isLetter(current)) {
				if (truthValues.get(current) == true) {
					result.add('T');
				} else {
					result.add('F');
				}
			} else {
				result.add(current);
			}
		}
		return result;
	}
	
	private static char evaluate(LinkedList<Character> proposition) {
		ListIterator<Character> it = proposition.listIterator();
		while (it.hasNext()) {
			char current = it.next();
			// If the start of a grouping is found, removes all elements in the grouping and adds them to a new array
			if (current == '(') {
				LinkedList<Character> grouping = new LinkedList<>();
				int parenthesesCount = 1;
				it.remove();
				while (true) {
					current = it.next();
					if (current == '(') {
						parenthesesCount++;
					} else  if (current ==')') {
						parenthesesCount--;
					}
					it.remove();
					if (parenthesesCount == 0) {
						break;
					} else {
						grouping.add(current);
					}
				}
				it.add(evaluate(grouping));
			}
		}
		return evaluateNoGrouping(proposition);
	}

	/**
	 * Evaluates a proposition that contains no grouping (no parentheses)
	 * @param proposition
	 * @return
	 */
	private static char evaluateNoGrouping(LinkedList<Character> proposition) {
		while (proposition.size() > 1) {
			// Check for negation
			if (proposition.get(0) == '!') {
				proposition.remove(0);
				if (proposition.get(0) == 'T') {
					proposition.set(0, 'F');
				} else {
					proposition.set(0, 'T');
				}
			} else {
				boolean term1;
				if (proposition.get(0) == 'T') {
					term1 = true;
				} else {
					term1 = false;
				}
				char operation = proposition.get(1);
				// Check for negation again
				boolean term2;
				if (proposition.get(2) == '!') {
					proposition.remove(2);
					if (proposition.get(2) == 'T') {
						term2  = false;
					} else {
						term2 = true;
					}
				} else {
					if (proposition.get(2) == 'T') {
						term2 = true;
					} else {
						term2 = false;
					}
				}
				boolean result;
				switch (operation) {
					case '&': 
						result = term1 & term2;
						break;
					case '|': 
						result = term1 | term2;
						break;
					case '^': 
						result = term1 ^ term2;
						break;
					case '>': 
						result = !term1 | term2;
						break;
					case '=': 
						result = (term1 == term2);
						break;
					default: throw new IllegalArgumentException("Operation " + operation + "  not recognized");
				}
				proposition.remove(0);
				proposition.remove(0);
				char resultChar;
				if (result == true) {
					resultChar = 'T';
				} else {
					resultChar = 'F';
				}
				proposition.set(0, resultChar);
			}
			
		}
		return proposition.get(0);
	}
}
