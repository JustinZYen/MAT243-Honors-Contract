package problem_2;
import java.util.*;
public class Problem2 {

	public static void main(String[] args) {
		String p;
		String q;
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter first bit string:");
			p = sc.next();
			System.out.println("Enter second bit string:");
			q = sc.next();
		}
		boolean[] pArr = bitStringToArray(p);
		boolean[] qArr = bitStringToArray(q);
		int length = pArr.length;
		if (qArr.length != length) {
			throw new InputMismatchException();
		}
		boolean[] bitAnd = new boolean[length];
		for (int i = 0; i < length; i++) {
			bitAnd[i] = pArr[i] && qArr[i];
		}
		boolean[] bitOr = new boolean[length];
		for (int i = 0; i < length; i++) {
			bitOr[i] = pArr[i] || qArr[i];
		}
		boolean[] bitXor = new boolean[length];
		for (int i = 0; i < length; i++) {
			bitXor[i] = pArr[i] ^ qArr[i];
		}
		System.out.println("Bitwise and: "+bitArrayToString(bitAnd));
		System.out.println("Bitwise or: "+bitArrayToString(bitOr));
		System.out.println("Bitwise xor: "+bitArrayToString(bitXor));

	}

	private static boolean[] bitStringToArray(String bitStr) {
		char[] array = bitStr.toCharArray();
		boolean[] result = new boolean[array.length];
		for (int i = 0; i < array.length; i++) {
			if (array[i] == '0') {
				result[i] = false;
			} else if (array[i] == '1') {
				result[i] = true;
			} else {
				throw new NumberFormatException("Element "+i+" of string "+bitStr+" is not a valid value");
			}
		}
		return result;
	}
	
	private static String bitArrayToString(boolean[] bitArr) {
		String result = "";
		for (boolean current:bitArr) {
			if (current == true) {
				result += "1";
			} else {
				result += "0";
			}
		}
		return result;
	}
}
