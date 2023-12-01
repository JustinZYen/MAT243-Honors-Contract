package problem_4;

import java.util.Scanner;

public class Problem4 {
	public static void main (String[] args) {
		double p;
		double q;
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter truth value of p: ");
			while (true) {
				if (sc.hasNext()) {
					if (sc.hasNextDouble()) {
						break;
					} else {
						sc.next();
						System.out.println("Reenter truth value of p: ");
					}
				}
			}
			p = sc.nextDouble();
			System.out.println("Enter truth value of q: ");
			while (true) {
				if (sc.hasNext()) {
					if (sc.hasNextDouble()) {
						break;
					} else {
						sc.next();
						System.out.println("Reenter truth value of q: ");
					}
				}
			}
			q = sc.nextDouble();
		}
		System.out.println("Conjunction of p and q: "+ (Math.min(p, q)));
		System.out.println("Disjunction of p and q: "+ (Math.max(p, q)));
	}
}
