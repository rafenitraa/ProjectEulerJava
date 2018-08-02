import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://projecteuler.net/problem=35
 * 
 * @author Stéphan R.
 *
 */
public class CircularPrimes {

	private static List<Integer> primes = new ArrayList<>();
	private static List<Integer> circularPrimes = new ArrayList<>();
	
	static void rotate(int[] arr, int length) {
		for(int shift = 1; shift <= length; shift++) {
			boolean skipRotation = (shift % length == 0) ? true : false;
			shift = (skipRotation) ? 1 : (length - (shift % length));

			if(!skipRotation) {
				for(int r = 0; r < shift; r++) {
					for(int i = 0; i < length; i++) {
						if(i != length - 1) {
							arr[i] = arr[i] ^ arr[length - 1];
							arr[length - 1] = arr[i] ^ arr[length - 1];
							arr[i] = arr[i] ^ arr[length - 1];
						}
					}
				}
				
				//if(String.join("", arr))
			}
		}
		
	}
	
	static void loadPrimes() {
		boolean[] tab = new boolean[(int) (Math.pow(10, 6) + 1)];
		
		for(int i = 2; i < Math.sqrt(tab.length); i++) {
			if(!tab[i]) {
				for(int j = (i * i); j < tab.length; j += i) {
					tab[j] = true;
				}
			}
		}
		
		for(int i = 2; i < tab.length; i++) {
			if(!tab[i]) {
				primes.add(i);
			}
		}
	}
	
	/**
	 * The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.
	 * There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
	 * How many circular primes are there below one million?
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		loadPrimes();
		System.out.println("");
	}
}