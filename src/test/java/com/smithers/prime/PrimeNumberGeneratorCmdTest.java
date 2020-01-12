package com.smithers.prime;

import org.junit.Test;

public class PrimeNumberGeneratorCmdTest {

	@Test
	public void testMain_NotEnoughArguments() {
		String[] arguments = {"1"};
		PrimeNumberGeneratorCmd.main(arguments);
	}
	
	@Test
	public void testMain_TooManyArguments() {
		String[] arguments = {"1", "10", "Extra arg"};
		PrimeNumberGeneratorCmd.main(arguments);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testMain_NotANumber() {
		String[] arguments = {"1", "Not a number"};
		PrimeNumberGeneratorCmd.main(arguments);
	}
	
	@Test
	public void testMain_Usage() {
		String[] arguments = {};
		PrimeNumberGeneratorCmd.main(arguments);
		
		arguments = new String[]{"-h"};
		PrimeNumberGeneratorCmd.main(arguments);
	}
	
	@Test
	public void testInitialize() {
		new PrimeNumberGeneratorCmd();
	}
	
}
