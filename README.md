# Prime Number
Prime Number Generator for an interview challenge

## Prime Number Definition
[According to Wikipedia](https://en.wikipedia.org/wiki/Prime_number):<br>
A prime number is a natural number larger than 1 which has exactly two distinct divisors: 1 and itself.<br>
The first twenty-six prime numbers are: [2, 3, 5, 7, 11, 13, 17, 19, 23,	29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89,	97, 101].

## Table of Contents:
* [Prime Number](#prime-number)
* [Prime Number Definition](#prime-number-definition)
* [Build](#build)
* [Usage](#usage)
* [Challenge Summary](#challenge-summary)
* [Choices](#choices)

### Build
**Environment:**
* Java 8
* Maven 3

**Instructions:**<br>
In the root directory of this repository execute `mvn clean install`

**Information:**<br>
The build process uses maven for build orchestration and dependency management. The only required dependency is JUnit 4.12 for unit tests. The build process utilizes [Jacoco](https://www.eclemma.org/jacoco/index.html) in order to ensure 100% code coverage during unit testing. An executable jar will be placed under the `target` directory (`updox-challenge-1.0.0.jar`). A source and java doc jar will also be generated.

### Usage
The prime number generation can be executed via the command line under the target directory using the following command:<br>
`java -jar updox-challenge-1.0.0.jar {starting number] {ending number}`
<p>
The usage information can be printed using the following command:<br>
`java -jar updox-challenge-1.0.0.jar -h`

## Challenge Summary
Create a prime number generator using the below interface.

```Java
public interface PrimeNumberGenerator {
	List<Integer> generate(int startingValue, int endingValue);
	boolean isPrime(int value);
}
```

**Test Specifications:**
* The code should handle inverse ranges such that 1-10 and 10-1 are equivalent.
* The code should output [7901, 7907, 7919] when the range 7900 and 7920 is provided.

## Choices
* I chose to not use a logging framework since the only information that needs to displayed, besides the results, is printed during command line usage and in that case we can use stdout and stderr. A logging framework could be used if we intend for this to be executed as a library rather than a command line utility.
