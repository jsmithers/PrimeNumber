package com.smithers.prime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class PrimeNumberGeneratorImplTest {

	public static final List<Integer> FIRST_26_PRIMES = Arrays.asList(2, 3, 5, 7, 
			11, 13, 17, 19, 23,	29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 
			79, 83, 89,	97, 101);
	public static final List<Integer> BASIC_PRIMES = Arrays.asList(2, 3, 5, 7);
	public static final List<Integer> LARGE_PRIMES = Arrays.asList(7901, 7907, 7919);
	
	private PrimeNumberGenerator generator = new PrimeNumberGeneratorImpl();
	
	// Is Prime methods tests
	@Test
	public void testIsPrime() {
		List<Integer> primes = FIRST_26_PRIMES.stream()
			.filter(generator::isPrime)
			.collect(Collectors.toList());
			
		// All of the primes should be present
		assertEquals(FIRST_26_PRIMES, primes);
	}
	
	@Test
	public void testIsPrime_negative() {
		int value = -1;
		assertFalse(this.generator.isPrime(value));
	}
	
	@Test
	public void testIsPrime_two() {
		int value = 2;
		assertTrue(this.generator.isPrime(value));
	}
	
	@Test
	public void testIsPrime_even() {
		int value = 12;
		assertFalse(this.generator.isPrime(value));
	}
	
	// Generate method tests
	@Test
	public void testGenerate_first26() {
		int startingBound = 0;
		int endingBound = 101;
		
		List<Integer> actualResults = this.generator.generate(startingBound, endingBound);
		assertEquals(FIRST_26_PRIMES, actualResults);
	}
	
	@Test
	public void testGenerate_first26_inverse() {
		int startingBound = 101;
		int endingBound = 0;
		
		List<Integer> actualResults = this.generator.generate(startingBound, endingBound);
		assertEquals(FIRST_26_PRIMES, actualResults);
	}
	
	@Test
	public void testGenerate_negativeValues() {
		int startingBound = -6;
		int endingBound = -3;
		
		List<Integer> actualResults = this.generator.generate(startingBound, endingBound);
		assertEquals(Arrays.asList(), actualResults);
	}
	
	@Test
	public void testGenerate_negativeValues_inverse() {
		int startingBound = -3;
		int endingBound = -6;
		
		List<Integer> actualResults = this.generator.generate(startingBound, endingBound);
		assertEquals(Arrays.asList(), actualResults);
	}
	
	@Test
	public void testGenerate_negativeValue_first26() {
		int startingBound = -4;
		int endingBound = 101;
		
		List<Integer> actualResults = this.generator.generate(startingBound, endingBound);
		assertEquals(FIRST_26_PRIMES, actualResults);
	}
	
	@Test
	public void testGenerate_negativeValue_first26_inverse() {
		int startingBound = 101;
		int endingBound = -4;
		
		List<Integer> actualResults = this.generator.generate(startingBound, endingBound);
		assertEquals(FIRST_26_PRIMES, actualResults);
	}
	
	// Updox test cases
	@Test
	public void testGenerate_basic() {
		int startingBound = 1;
		int endingBound = 10;
		
		List<Integer> actualResults = this.generator.generate(startingBound, endingBound);
		assertEquals(BASIC_PRIMES, actualResults);
	}
	
	@Test
	public void testGenerate_basic_inverse() {
		int startingBound = 10;
		int endingBound = 1;
		
		List<Integer> actualResults = this.generator.generate(startingBound, endingBound);
		assertEquals(BASIC_PRIMES, actualResults);
	}
	
	@Test
	public void testGenerate_large() {
		int startingBound = 7900;
		int endingBound = 7920;
		
		List<Integer> actualResults = this.generator.generate(startingBound, endingBound);
		assertEquals(LARGE_PRIMES, actualResults);
	}
	
}
