package com.smithers.prime;

import java.util.List;

public class PrimeNumberGeneratorCmd {

	public static void main(String[] args) {
		int length = args.length;
		// If the user supplied 0 arguments or the "-h" arugment, they want the usage information
		if (length == 0 || 
				(length == 1 && args[0].equalsIgnoreCase("-h"))) {
			printUsage();
			return;
		} else if (length > 2) {
			System.err.println("More than two arguments were provided, using only the first two.");
		} else if (length < 2) {
			System.err.println("Not enough arguments were supplied, two numbers are required and only '1' was provided");
			printUsage();
			return;
		}
		
		try {
			// Convert the arguments to numbers
			int start = convertArgumentToNumber(args, 0);
			int end = convertArgumentToNumber(args, 1);
			
			// Generate and print the prime numbers
			PrimeNumberGenerator generator = new PrimeNumberGeneratorImpl();
			List<Integer> primes = generator.generate(start, end);
			primes.forEach(System.out::println);
		} catch (Throwable error) {
			// Since we get an error, we might want to inform the user of how to use the program
			System.err.println("Caught error: " + error.getMessage());
			printUsage();
			
			// We are really only printing the error so that the user is informed of the exact issue
			throw error;
		}
	}

	protected static int convertArgumentToNumber(String[] args, int index) throws IndexOutOfBoundsException, IllegalArgumentException {
		String string = args[index];
		try {
			return Integer.parseInt(string);
		} catch (NumberFormatException nfe) {
			throw new IllegalArgumentException("The argument '" + string + "' at index '" + index + "' is not a number.", nfe);
		}
	}
	
	public static void printUsage() {
		System.out.println("Usage: " + PrimeNumberGeneratorImpl.class.getName() + " {starting number} {ending number}");
		System.out.println("Displays a list of prime numbers between the starting number and ending number. The list of prime numbers is printed with a new line separating each entry.");
	}
	
}
