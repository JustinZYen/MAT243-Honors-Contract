package problem_1;

import java.util.Scanner;

public class Problem1 {

	public static void main(String[] args) {
		boolean p;
		boolean q;
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter truth value of p: ");
			while (true) {
				if (sc.hasNext()) {
					if (sc.hasNextBoolean()) {
						break;
					} else {
						sc.next();
						System.out.println("Reenter truth value of p: ");
					}
				}
			}
			p = sc.nextBoolean();
			System.out.println("Enter truth value of q: ");
			while (true) {
				if (sc.hasNext()) {
					if (sc.hasNextBoolean()) {
						break;
					} else {
						sc.next();
						System.out.println("Reenter truth value of q: ");
					}
				}
			}
			q = sc.nextBoolean();
		}

		System.out.println("Conjunction of p and q: "+ (p&&q));
		System.out.println("Disjunction of p and q: "+ (p||q));
		System.out.println("Exclusive or of p and q: "+ (p^q));
		System.out.println("Conditional statement of p and q: "+ (!p||q));
		System.out.println("Biconditional of p and q: "+ (p==q));
	}

}
