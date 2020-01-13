package com.smithers.prime;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Basic implementation of the {@link PrimeNumberGenerator}.
 * 
 * @author Jonathan Smithers
 * @since 1.0
 */
public class PrimeNumberGeneratorImpl implements PrimeNumberGenerator {

	/** {@inheritDoc} */
	@Override
	public List<Integer> generate(int startingValue, int endingValue) {
		// This ensures that the arguments are interchangeable, 
		//  The start is the smallest and the end is the largest
		int start = Math.min(startingValue, endingValue);
		int end = Math.max(startingValue, endingValue);
		
		// Create a stream of integers between startingValue and endingValue, inclusively
		IntStream stream = IntStream.rangeClosed(start, end);
		return stream
				.filter(this::isPrime) // Filter the stream so that only primes are maintained
				// Take the remaining values and collect them into a list
				.collect(ArrayList<Integer>::new, ArrayList::add, ArrayList::addAll); 
	}

	/** {@inheritDoc} */
	@Override
	public boolean isPrime(int value) {
		// negative numbers, 0, and 1 are not primes
		if (value <= 1 
				// 2 is the only even number that is a prime
				|| (this.isDivisible(value, 2) && value != 2)) {
			return false;
		} else {
			// We only need to go to half the number's value because the minimum divisor is 2
			//  We can start at 3 because we have already ruled out 2 and every number is divisible by 1
			//  We can increment by 2 because no even numbers larger than 2 are primes, 3, 5, 7, etc...
			for (int number = 3; number < (value / 2); number += 2) {
				if (this.isDivisible(value, number)) {
					return false;
				}
			}
			
			return true;
		}
	}
	
	/**
	 * Determines if the numerator is divisible by the denominator.
	 * 
	 * @param numerator
	 * 			The number that we want to determine if it is divisible by the denominator.
	 * @param denominator
	 * 			The number by which we want to determine if the numerator is divisible.
	 * @return Returns true if the numerator is divisible by the denominator, false otherwise.
	 */
	protected boolean isDivisible(int numerator, int denominator) {
		return numerator % denominator == 0;
	}
	
}
