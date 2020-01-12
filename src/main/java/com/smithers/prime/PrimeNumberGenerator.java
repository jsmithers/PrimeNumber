package com.smithers.prime;

import java.util.List;

/**
 * Prime number generator interface.
 * <p>
 * Prime number definition:<br>
 *  A prime number is a natural number that is only divisible by 1 and itself.<br>
 *  The first 26 prime numbers are: 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 
 *   37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, and 101.
 * 
 * @author Jonathan Smithers
 * @since 1.0
 */
public interface PrimeNumberGenerator {
	
	/**
	 * Generates a list of integers between the startingValue and endingValue 
	 *  parameters, inclusively, that are prime numbers. If this method is called
	 *  with values 6 and 15, a list containing [7, 11, 13] would be returned. 
	 *  This method treats inverse combinations of arguments the same, meaning
	 *  1 and 10, and 10 and 1 result in the same list.
	 * <p>
	 * Since "natural numbers" are positive, negative numbers will be changed to
	 *  zero. This means that if arguments -2 and 7 are provided, a list containing
	 *  [2, 3, 5, 7] will be returned; and if arguments -3 and -1 are provided,
	 *  a list with no entries will be returned.
	 * 
	 * @param startingValue
	 * 			The starting value from which to search for prime numbers. If it is 
	 * 			 larger than the ending value, the two values will be flipped.
	 * @param endingValue
	 * 			The ending value to which to search for prime numbers. If it is 
	 * 			 smaller than the starting value, the two values will be flipped.
	 * @return Returns a list containing all prime numbers between the provided numbers.
	 * 			If there are no prime numbers between the two provided numbers, an empty
	 * 			list will be returned. 
	 */
	public List<Integer> generate(int startingValue, int endingValue);
	
	/**
	 * Determines if the provided parameter is a prime number or not. 
	 * 
	 * @param value
	 * 			The value for which we want to determine if it is a prime number.
	 * @return Returns true if the number is a prime, false otherwise.
	 */
	public boolean isPrime(int value);

}